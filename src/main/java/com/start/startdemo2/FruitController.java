package com.start.startdemo2;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.List;

@RestController
public class FruitController {

    @PostMapping("/fruit")
    public ResponseEntity<HashSet<Fruit>> citygo(@RequestBody List<Fruit> body){
        HashSet<Fruit> hashSet = new HashSet(body);
        return ResponseEntity.ok().body(hashSet);

    }
}
