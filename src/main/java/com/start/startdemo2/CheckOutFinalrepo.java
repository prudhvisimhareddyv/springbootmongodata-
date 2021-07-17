package com.start.startdemo2;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CheckOutFinalrepo extends MongoRepository<CheckOutFinal,Integer> {

    @Query("{ 'Username': ?0}")
    List<CheckOutFinal> findByUsername(@Param("userid") String userid);
}
