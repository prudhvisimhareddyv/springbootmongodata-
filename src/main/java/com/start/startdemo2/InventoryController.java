package com.start.startdemo2;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;

@RestController
public class InventoryController {

    @Autowired
    InventoryRepository Inventoryrepo;
    @PostMapping("/Inventory")
    public ResponseEntity<HashSet<Inventory>> Inventory(@RequestBody List<Inventory> body) {
        HashSet<Inventory> hashSets = new HashSet(body);
        Inventoryrepo.saveAll(hashSets);
        return ResponseEntity.ok().body(hashSets);

    }
    @GetMapping("/Inventory/selectall")
    public ResponseEntity<List<Inventory>> Inventoryall() {
        List<Inventory> data = Inventoryrepo.findAll();

        return ResponseEntity.ok().body(data);

    }
    @GetMapping("/Inventory/selectonly")
    public ResponseEntity<List<Inventory>> Inventoryonly(@RequestParam("status") String status) {
        List<Inventory> data = Inventoryrepo.findByInventorystatus(status);

        return ResponseEntity.ok().body(data);

    }
    @GetMapping("/Inventory/selectin")
    public ResponseEntity<List<Inventory>> Inventoryin(@RequestParam("status1") String status1,@RequestParam("status2") String status2) {
        List<Inventory> data = Inventoryrepo.findByInventoryin(status1,status2);

        return ResponseEntity.ok().body(data);

    }
    @GetMapping("/Inventory/selectand")
    public ResponseEntity<List<Inventory>> Inventoryand(@RequestParam("status") String status,@RequestParam("qty") int qty) {
        List<Inventory> data = Inventoryrepo.findByInventoryand(status,qty);

        return ResponseEntity.ok().body(data);

    }

    @GetMapping("/Inventory/selector")
    public ResponseEntity<List<Inventory>> Inventoryor(@RequestParam("status") String status,@RequestParam("qty") int qty) {
        List<Inventory> data = Inventoryrepo.findByInventoryor(status,qty);

        return ResponseEntity.ok().body(data);

    }

    @GetMapping("/Inventory/selectorand")
    public ResponseEntity<List<Inventory>> Inventoryorand(@RequestParam("status") String status,@RequestParam("qty") int qty,@RequestParam("item") String item) {
        List<Inventory> data = Inventoryrepo.findByInventoryorand(status, qty,item);

        return ResponseEntity.ok().body(data);

    }
    @GetMapping("/Inventory/select3")
    public ResponseEntity<List<Inventory>> Inventory3(@RequestParam("h") int h,@RequestParam("w") int w,@RequestParam("uom") String uom) {
        List<Inventory> data = Inventoryrepo.findByInventoryorand(h, w,uom);

        return ResponseEntity.ok().body(data);

    }
    @GetMapping("/Inventory/select4")
    public ResponseEntity<List<Inventory>> Inventory4(@RequestParam("uom") String uom) {
        List<Inventory> data = Inventoryrepo.findByInventoryuom(uom);

        return ResponseEntity.ok().body(data);

    }

    @GetMapping("/Inventory/select5")
    public ResponseEntity<List<Inventory>> Inventory4(@RequestParam("h") int h,@RequestParam("uom") String uom,@RequestParam("status") String status) {
        List<Inventory> data = Inventoryrepo.findByInventoryAndd(h,uom,status);

        return ResponseEntity.ok().body(data);

    }
}
