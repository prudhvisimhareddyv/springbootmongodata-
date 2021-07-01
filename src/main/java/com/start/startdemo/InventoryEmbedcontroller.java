package com.start.startdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;

@RestController
public class InventoryEmbedcontroller {

    @Autowired
    InventoryEmbedRepository inemrepo;

    @PostMapping("/inventoryembed")
    public ResponseEntity<HashSet<InventoryEmbed>> Item(@RequestBody List<InventoryEmbed> body) {
        HashSet<InventoryEmbed> hashSets = new HashSet(body);
        inemrepo.saveAll(hashSets);
        return ResponseEntity.ok().body(hashSets);

    }

    @GetMapping("/inventoryembed/find")
    public ResponseEntity<List<InventoryEmbed>> Itemonly(@RequestParam("warehouse") String warehouse, @RequestParam("qty") int qty) {
        List<InventoryEmbed> data = inemrepo.findByInstock(warehouse,qty);

        return ResponseEntity.ok().body(data);

    }
    @GetMapping("/inventoryembed/findbyqty")
    public ResponseEntity<List<InventoryEmbed>> Itemonly(@RequestParam("qty") int qty) {
        List<InventoryEmbed> data = inemrepo.findByInstockqty(qty);

        return ResponseEntity.ok().body(data);

    }
    @GetMapping("/inventoryembed/findele")
    public ResponseEntity<List<InventoryEmbed>> Itemonlyele(@RequestParam("warehouse") String warehouse, @RequestParam("qty") int qty) {
        List<InventoryEmbed> data = inemrepo.findByInstockele(warehouse,qty);

        return ResponseEntity.ok().body(data);

    }
}
