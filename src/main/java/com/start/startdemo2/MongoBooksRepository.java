package com.start.startdemo2;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoBooksRepository extends MongoRepository<MongoBooks, Integer> {

}
