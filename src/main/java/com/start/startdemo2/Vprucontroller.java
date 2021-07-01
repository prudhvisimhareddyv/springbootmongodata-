package com.start.startdemo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;

@RestController
public class Vprucontroller {
    @Autowired
    private Vprurepo vprurepo;
    @GetMapping("/vpru")
    public List<Vpru> listAll(Model model) {
        List<Vpru> listvpru = vprurepo.findAll();

        return listvpru;
    }
    @PostMapping("/vprudetails")
    public ResponseEntity<HashSet<Vpru>> vprudet(@RequestBody List<Vpru> body) {
        HashSet<Vpru> hashSet = new HashSet(body);

        vprurepo.saveAll(hashSet);

        return ResponseEntity.ok().body(hashSet);

    }


}
