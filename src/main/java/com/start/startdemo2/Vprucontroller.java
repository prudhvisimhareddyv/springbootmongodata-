package com.start.startdemo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@RestController
public class Vprucontroller {
    @Autowired
    private Vprurepo vprurepo;
    @GetMapping("/vpru")
    public ResponseEntity<List<Vpru>> listAll(Model model) {
        List<Vpru> listvpru = vprurepo.findAll();

        return ResponseEntity.ok().body(listvpru);

    }
    @PostMapping("/vprudetails")
    public ResponseEntity<HashSet<Vpru>> vprudet(@RequestBody List<Vpru> body) {
        HashSet<Vpru> hashSet = new HashSet(body);

       vprurepo.

        return ResponseEntity.ok().body(hashSet);

    }
    @DeleteMapping("/vprudelete")
    public ResponseEntity<String> deleterecord(@RequestParam("id") int id){

        vprurepo.deleteById(id);
        return ResponseEntity.ok().body("Successfully deleted");
    }
    @PutMapping("/vprudetails/update")
    public ResponseEntity<String> vprudetupdate(@Param("cvreyId") int cvreyId, @Param("Firstname ") String Firstname) {


        vprurepo.UpdateByxyz(cvreyId,Firstname);
        return ResponseEntity.ok().body("success");
    }

}
