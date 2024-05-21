package com.spring.reserves.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.spring.reserves.model.Reserve;

public interface MongoDbRepository extends MongoRepository<Reserve, String> {
}
