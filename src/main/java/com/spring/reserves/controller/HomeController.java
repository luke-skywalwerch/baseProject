package com.spring.reserves.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.spring.reserves.model.Reserve;
import com.spring.reserves.repository.MongoDbRepository;

// annotation to define controller
@Controller
public class HomeController {

    // annotation to inject the repository
    @Autowired
    private MongoDbRepository mongoRepo;

    // this endpoint is accessible in http://localhost:8080/ and will return the
    // html in templates/home.html
    @GetMapping("/")
    public String showHome(Model model) {
        List<Reserve> reserves = mongoRepo.findAll();
        model.addAttribute("reserves", reserves);
        return "home";
    }

    // this endpoint is accessible in http://localhost:8080/add but does not return
    // an html, it returns an http response that can be handled in client (js) if needed
    @PostMapping("/add")
    public ResponseEntity<Object> addReserve(@RequestBody Reserve reserve) {
        try {
            return ResponseEntity.ok(mongoRepo.save(reserve));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error adding movie: " + e.getMessage());
        }
    }
}
