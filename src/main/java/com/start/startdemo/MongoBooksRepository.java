package com.start.startdemo;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoBooksRepository extends MongoRepository<MongoBooks, Integer> {

}
