package com.start.startdemo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
public class AlwaysuLscontroller extends ArrayList {


    @Autowired
    Alwaysurepo alwaysurepo;

    @Autowired
    CheckOutFinalrepo checkoutfinalrepo;


    @GetMapping("/display1")
    public ResponseEntity<HashSet<Alwaysubuy>> display(){

        List<Alwaysubuy> data = alwaysurepo.findAll();
        //ArrayList<Alwaysubuy> data1 = new ArrayList<Alwaysubuy>(data);

       HashSet<Alwaysubuy>  data1 = new HashSet<>();
       for(Alwaysubuy al : data){

            data1.add(al);
        }

        return ResponseEntity.ok().body(data1);
    }

    @PostMapping("/lspost")
    public ResponseEntity lspost(@RequestBody List<CheckOutFinal> buys, @RequestParam("Userid") String Userid){

        Alwaysubuy a = new Alwaysubuy();
        Set<CheckOutFinal> ls = new HashSet<CheckOutFinal>(buys);
        for (CheckOutFinal coo : ls) {

            System.out.println(coo + ": " + Collections.frequency(buys, coo));
             if (ls.contains(coo)) {
                  //  a.setValue(Collections.frequency(buys, coo));

            } else {
                //a.setValue(1);
            }
        }
        CheckOutFinal cof = new CheckOutFinal();
        cof.setUsername(Userid);
        cof.setLs(ls);

        checkoutfinalrepo.save(cof);

        return ResponseEntity.ok().body("done");
    }

}
