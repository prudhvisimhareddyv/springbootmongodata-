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
    public ResponseEntity<List<Vpru>> listAll(/*Model model*/@Param("CvreyID") int CvreyID) {

        List<Vpru> listvpru = vprurepo.SelectBy(CvreyID);
        return ResponseEntity.ok().body(listvpru);

    }
    @PostMapping("/vprudetails")
    public ResponseEntity<List<Vpru>> vprudet(@Param("CvreyID") int CvreyID, @Param("LastName") String LastName,@Param("FirstName") String FirstName,@Param("Address") String Address,@Param("City") String City) {


        List<Vpru> listvpru = vprurepo.InsertByBody(CvreyID,LastName,FirstName,Address,City);
        // =  vprurepo.findAll();
        return ResponseEntity.ok().body(listvpru);

    }
    @DeleteMapping("/vprudelete")
    public ResponseEntity<String> deleterecord(@RequestParam("id") int id){

        vprurepo.deleteById(id);
        return ResponseEntity.ok().body("Successfully deleted");
    }
    @PutMapping("/vprudetails/update")
    public ResponseEntity<String> vprudetupdate(@Param("cvreyId") int cvreyId, @Param("Firstname ") String Firstname) {


        List<Vpru> l=vprurepo.Updatelist(cvreyId,Firstname);
        System.out.println("This is list type"+l.size());
        return ResponseEntity.ok().body("success");
    }

    @GetMapping("/vpruall")
    public ResponseEntity<List<Vpru>> listAll() {

        List<Vpru> listvpru = vprurepo.Selectall();
        return ResponseEntity.ok().body(listvpru);

    }
    @GetMapping("/vpruand")
    public ResponseEntity<List<Vpru>> listAnd(@Param("cvrey_id") int cvrey_id, @Param("address")  String address) {

        List<Vpru> listvpru = vprurepo.findBycvreyidandaddress(cvrey_id,address);
        return ResponseEntity.ok().body(listvpru);

    }

    @GetMapping("/vpruor")
    public ResponseEntity<List<Vpru>> listor(@Param("cvrey_id") int cvrey_id, @Param("address")  String address) {

        List<Vpru> listvpru = vprurepo.findBycvreyidoraddress(cvrey_id,address);
        return ResponseEntity.ok().body(listvpru);

    }

    @GetMapping("/countall")
    public ResponseEntity<List<Vpru>> countall() {

        List<Vpru> listvpru = vprurepo.countalls();
        return ResponseEntity.ok().body(listvpru);

    }

}
