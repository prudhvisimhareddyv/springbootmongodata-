package com.start.startdemo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;

@RestController
public class Itemcontroller {


    @Autowired
    Itemrepository itemrepo;

    @PostMapping("/item")
    public ResponseEntity<HashSet<Item>> Item(@RequestBody List<Item> body) {
        HashSet<Item> hashSets = new HashSet(body);
        itemrepo.saveAll(hashSets);
        return ResponseEntity.ok().body(hashSets);

    }
    @GetMapping("/Item/check")
    public ResponseEntity<List<Item>> Itemonly(@RequestParam("tags1") String tags1,@RequestParam("tags2") String tags2) {
        List<Item> data = itemrepo.findByItemtags(tags1,tags2);

        return ResponseEntity.ok().body(data);

    }

    @GetMapping("/Item/checks")
    public ResponseEntity<List<Item>> Itemonlyall(@RequestParam("tags1") String tags1,@RequestParam("tags2") String tags2) {
        List<Item> data = itemrepo.findByItemtagsall(tags1,tags2);

        return ResponseEntity.ok().body(data);

    }
    @GetMapping("/Item/checksall")
    public ResponseEntity<List<Item>> Itemonlys(@RequestParam("dim_cm") int dim_cm) {
        List<Item> data = itemrepo.findByItemdim_cm(dim_cm);

        return ResponseEntity.ok().body(data);

    }
    @GetMapping("/Item/checksalld")
    public ResponseEntity<List<Item>> Itemonlys(@RequestParam("dim_cm1") int dim_cm1,@RequestParam("dim_cm2") int dim_cm2) {
        List<Item> data = itemrepo.findByItemdim_cms(dim_cm1,dim_cm2);

        return ResponseEntity.ok().body(data);

    }

    @GetMapping("/Item/checknas")
    public ResponseEntity<List<Item>> Itemonlynas(@Param("nas") int nas) {
        List<Item> data = itemrepo.findByItemnas(nas);

        return ResponseEntity.ok().body(data);

    }

}
