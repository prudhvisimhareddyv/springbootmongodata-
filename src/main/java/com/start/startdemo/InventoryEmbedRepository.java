package com.start.startdemo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface InventoryEmbedRepository extends MongoRepository<InventoryEmbed,Integer> {

    @Query( "{ instock: { warehouse: ?0, qty: ?1 } }")
    List<InventoryEmbed> findByInstock (@Param("warehouse") String warehouse, @Param("qty") int qty);

    @Query("{ 'instock.0.qty': { $lte: ?0 } }")
    List<InventoryEmbed> findByInstockqty (@Param("qty") int qty);

    @Query( "{ instock: { $elemMatch: { qty: ?1, warehouse: ?0 } } }")
    List<InventoryEmbed> findByInstockele (@Param("warehouse") String warehouse, @Param("qty") int qty);
}
