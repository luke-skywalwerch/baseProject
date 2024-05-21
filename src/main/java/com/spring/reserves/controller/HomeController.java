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

@Controller
public class HomeController {

    @Autowired
    private MongoDbRepository mongoRepo;

    @GetMapping("/")
    public String showHome(Model model) {
        List<Reserve> reserves = mongoRepo.findAll();
        model.addAttribute("reserves", reserves);
        return "home";
    }


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
