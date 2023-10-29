package com.example.hexagonal.framework.adapter.out.mongodb.repository;

import com.example.hexagonal.framework.adapter.out.mongodb.entity.MacBookMongoEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MacBookMongoRepository extends MongoRepository<MacBookMongoEntity, String> {

}