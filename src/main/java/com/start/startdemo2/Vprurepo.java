package com.start.startdemo2;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Repository
public interface Vprurepo extends JpaRepository<Vpru,Integer> {


    @Transactional
    @Modifying
    @Query("update Vpru u set u.FirstName = ?2 where u.CvreyID = ?1")
    int UpdateByxyz(@Param("cvreyId") int cvreyId, @Param("Firstname") String Firstname);

    @Transactional
    @Modifying
    @Query("update Vpru u set u.FirstName = ?2 where u.CvreyID = ?1")
    List<Vpru> Updatelist(@Param("cvreyId") int cvreyId, @Param("Firstname") String Firstname);

    @Transactional
    @Modifying
    @Query(value = "insert into vpru (cvrey_id, last_name, first_name, address,city) values (?1,?2 , ?3, ?4,?5)",
            nativeQuery = true)
    int InsertByBody(@Param("CvreyID") int CvreyID, @Param("LastName") String LastName, @Param("FirstName") String FirstName, @Param("Address") String Address, @Param("City") String City );



    @Query(value = "select * from vpru where cvrey_id = ?1", nativeQuery = true)
    List<Vpru> SelectBy(@Param("CvreyID") int CvreyID);



    @Query(value = "select * from vpru", nativeQuery = true)
    List<Vpru> Selectall();



   @Query(value = "select * from vpru where cvrey_id = ?1 and address= ?2", nativeQuery = true)
    List<Vpru> findBycvreyidandaddress(@Param("cvrey_id") int cvrey_id, @Param("address")  String address);




    @Query(value = "select * from vpru where cvrey_id = ?1 or address= ?2", nativeQuery = true)
    List<Vpru> findBycvreyidoraddress(@Param("cvrey_id") int cvrey_id, @Param("address")  String address);



    @Query(value = "select count(*) from vpru", nativeQuery = true)
    List<Vpru> countalls();

}
