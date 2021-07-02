package com.start.startdemo2;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public interface Vprurepo extends JpaRepository<Vpru,Integer> {


    @Transactional
    @Modifying
    @Query("update Vpru u set u.FirstName = ?2 where u.CvreyID = ?1")
    int UpdateByxyz(@Param("cvreyId") int cvreyId, @Param("Firstname") String Firstname);

    @Transactional
    @Modifying
    @Query("INSERT INTO Vpru (CvreyID, LastName, FirstName, Address, City)" +
            "VALUES ('Cardinal', 'Tom B. Erichsen', 'Skagen 21', 'Stavanger', '4006', 'Norway');")
    int InsertByBody(@RequestBody List<Vpru> vpru);





}
