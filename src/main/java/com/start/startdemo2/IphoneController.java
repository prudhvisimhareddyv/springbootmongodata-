package com.start.startdemo2;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
public class IphoneController {

    @PostMapping("/iphone")
    public ResponseEntity<HashSet<Iphone>> iphoneSale(@RequestBody List<Iphone> Body){
            //Set<Iphone> ss = new HashSet<Iphone>(Body);
        HashSet<Iphone> hashSet = new HashSet(Body);
        return ResponseEntity.ok().body(hashSet);
    }
    @PostMapping("/iphoneset")
    public ResponseEntity<Set<Iphone>> thtjt(@RequestBody Set<Iphone> Body){

        return ResponseEntity.ok().body(Body);
    }
    @PostMapping("/iphone1")
    public ResponseEntity<Set<String>> theiphone(@RequestBody Iphone Body){
            Set<String> body = new HashSet<String>();
            body.add(Body.getColour());
            body.add(Body.getColour1());
        return ResponseEntity.ok().body(body);
    }

}
