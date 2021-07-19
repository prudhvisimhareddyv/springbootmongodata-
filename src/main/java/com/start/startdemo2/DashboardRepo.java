package com.start.startdemo2;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface DashboardRepo extends MongoRepository<Dashboard,Integer> {

    @Query("{'year':?0 , 'gameFormat':?1}")
    List<Dashboard> findByyearformat (@Param("year") int year,@Param("format") String format );

    @Query(" {'year': ?0 , 'playerCountry': ?1} ")
    List<Dashboard> findByyearcountry (@Param("year") int year,@Param("country") String country);


    @Query(" {'playerName': ?0} ")
    List<Dashboard> findByyearbyplayer (@Param("player") String player);


    @Query(" {'year': ?0} ")
    List<Dashboard> findByyear(@Param("year") int year);



}
