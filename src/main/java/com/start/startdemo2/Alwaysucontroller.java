package com.start.startdemo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class Alwaysucontroller {
        @Autowired
        Alwaysurepo alwaysurepo;

        @Autowired
        CheckOutFinalrepo checkoutfinalrepo;


    @GetMapping("/display")
    public ResponseEntity<List<Alwaysubuy>> display(){

        List<Alwaysubuy> data = alwaysurepo.findAll();

        return ResponseEntity.ok().body(data);
    }

    @PostMapping("/useritems")
    public ResponseEntity buy(@RequestBody List<Checkout> buys, @RequestParam("Userid") String Userid) {

        //Checkout co = new Checkout();
        if (Userid.isEmpty() || Userid.isBlank() ||buys.isEmpty()) {
            return ResponseEntity.ok().body("please enter username");
        } else {
            Map<String, Integer> Mco = new HashMap<String, Integer>();

            int count = 0;
            for (Checkout coo : buys) {
                String items = coo.getProductnames();
                if(items.isEmpty()||items.isBlank()) {
                    return ResponseEntity.badRequest().body("Please enter productname");
                }
                    else if (Mco.containsKey(items)) {

                        count = Mco.get(items);
                        count++;
                        Mco.put(items, count);
                    } else {
                        Mco.put(items, 1);
                    }



                System.out.println(items);
            }
            System.out.println(Mco);
            CheckOutFinal cof = new CheckOutFinal();
            cof.setUsername(Userid);
            //cof.setMco(Mco);

            checkoutfinalrepo.save(cof);


        return ResponseEntity.ok().body("done");
    }
    }
    @GetMapping("/displayback")
    public ResponseEntity<List<CheckOutFinal>> displayback(@RequestParam("userid") String userid){


        List<CheckOutFinal> data = checkoutfinalrepo.findByUsername(userid);

        return ResponseEntity.ok().body(data);
    }
}
