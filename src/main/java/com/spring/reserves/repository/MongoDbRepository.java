package com.spring.reserves.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.spring.reserves.model.Reserve;

// use your model and the type of your id property inside the <>
public interface MongoDbRepository extends MongoRepository<Reserve, String> {
}
