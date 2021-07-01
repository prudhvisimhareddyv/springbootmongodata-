package com.start.startdemo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface InventoryRepository extends MongoRepository<Inventory,Integer> {

    @Query("{ 'status': ?0}")
    List<Inventory> findByInventorystatus (@Param("status") String status);



    @Query("{ 'status': {$in:[?0,?1]}}")
    List<Inventory> findByInventoryin (@Param("status1") String status1,@Param("status2") String status2);


    @Query( "{  'qty': { $lt: ?1 } ,'status': ?0}")
    List<Inventory> findByInventoryand (@Param("status") String status,@Param("qty") int qty);

    @Query( "{ $or: [ { 'status': ?0 }, { 'qty': { $lt: ?1 } } ]}")
    List<Inventory> findByInventoryor (@Param("status") String status,@Param("qty") int qty);


    @Query("{ status: ?0, $or: [ { qty: { $lt: ?1 } }, { item: ?2 } ] }")
    List<Inventory> findByInventoryorand (@Param("status") String status,@Param("qty") int qty,@Param("item") String item);

    @Query("{ size: { h: ?0, w: ?1, uom: ?2 } }")
    List<Inventory> findByInventoryorand (@Param("h") int h,@Param("w") int w,@Param("uom") String uom);

    @Query("{ 'size.uom': ?0 }")
    List<Inventory> findByInventoryuom (@Param("uom") String uom);

    @Query("{ 'size.h': { $lt: ?0 }, 'size.uom': ?1, status: ?2 }")
    List<Inventory> findByInventoryAndd (@Param("h") int h,@Param("uom") String uom,@Param("status") String status);

}
