package com.start.startdemo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Itemrepository extends MongoRepository<Item,Integer> {

    @Query( "{ tags: [?0,?1] }")
    List<Item> findByItemtags (@Param("tags1") String tags1,@Param("tags2") String tags2);

    @Query(" { tags: { $all: [?0,?1 ] } }")
    List<Item> findByItemtagsall (@Param("tags1") String tags1,@Param("tags2") String tags2);

    @Query(" { dim_cm: { $gt: ?0 } }")
    List<Item> findByItemdim_cm (@Param("dim_cm") int dim_cm);

    @Query("{ dim_cm: { $gt: ?0, $lt: ?1 } }")
    List<Item> findByItemdim_cms (@Param("dim_cm1") int dim_cm1,@Param("dim_cm2") int dim_cm2);

    @Query(" { tags: { $size: ?0 } }")
    List<Item> findByItemnas (@Param("nas") int nas);
}
