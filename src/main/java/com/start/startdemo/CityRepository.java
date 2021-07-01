package com.start.startdemo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CityRepository extends MongoRepository<City,Integer> {

    @Query("{'cityname':?0}")
    Optional<List<City>> findBycitynamexyz (@Param("cityname") String cityname);
    Optional<List<City>> findBycityname (@Param("cityname") String cityname);
    Optional<List<City>> findByzipcode (@Param("zipcode") int zipcode);

    @Query("{'cityname' : ?0 , 'zipcode' : ?1}")
    Optional<List<City>> findCityBycitynameAndzipcode(@Param("cityname") String cityname,@Param("zipcode")  int zipcode);

    @Query("{'zipcode' : {$gt : ?0, $lt : ?1}}")
    Optional<List<City>> findCityByZipcodeRange(  int zipcode1, int zipcode2);

    @Query( "{'cityname':{$in:[?0,?1]}}")
    Optional<List<City>> findCityBycityname(@Param("cityname1") String cityname1,@Param("cityname2")  String cityname2);

    @Query( "{'cityname':{$in:?0}}")
    Optional<List<City>> findCityBycitynamelist(  List citys);

    @Query(value ="{cityname: ?0}", count=true)
    int findCityBycitynamecount(  String cityname);

}
/*{ item: "journal", qty: 25, size: { h: 14, w: 21, uom: "cm" }, status: "A" }
        { item: "notebook", qty: 50, size: { h: 8.5, w: 11, uom: "in" }, status: "A" }
        { item: "paper", qty: 100, size: { h: 8.5, w: 11, uom: "in" }, status: "D" }
        { item: "planner", qty: 75, size: { h: 22.85, w: 30, uom: "cm" }, status: "D" }
        { item: "postcard", qty: 45, size: { h: 10, w: 15.25, uom: "cm" }, status: "A" }*/