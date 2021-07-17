package com.start.startdemo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.*;

@RestController
public class Vprucontroller {
    @Autowired
    private Vprurepo vprurepo;

    private Vpru vpru;
    @GetMapping("/vpru")
    public ResponseEntity<List<Vpru>> listAll(/*Model model*/@Param("CvreyID") int CvreyID) {

        List<Vpru> listvpru = vprurepo.SelectBy(CvreyID);
        return ResponseEntity.ok().body(listvpru);

    }
    @PostMapping("/vprudetails")
    public ResponseEntity vprudet(@Param("CvreyID") int CvreyID, @Param("LastName") String LastName, @Param("FirstName") String FirstName, @Param("Address") String Address, @Param("City") String City) {


        int setpru = vprurepo.InsertByBody(CvreyID,LastName,FirstName,Address,City);
        // =  vprurepo.findAll();
        //vpru.setFirstName("");

        return ResponseEntity.ok().body(setpru);

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
    //List li = new ArrayList();
    @GetMapping("/printlist")
    public ResponseEntity listmethods(){

        List<String> list = new ArrayList();
        list.add("pru");
        list.add(0,"V");
        //list.add(1);
        System.out.println(list);
        System.out.println(list.size());
        System.out.println(list.isEmpty());
        System.out.println(list.contains("pru"));
        //System.out.println(list.indexOf(1));
        System.out.println(list.lastIndexOf(1));
        String[] arr = list.toArray(String[]::new);

        for (String x : arr)
            System.out.print(x + " ");
        System.out.println("\n"+list.get(1));
        System.out.println("\n"+list.set(1,"reddy"));
        System.out.println("\n"+list.remove(1));
        System.out.println("\n"+list.equals(list));
        System.out.println("\n"+list.hashCode());
        System.out.println(list.addAll(0,list));
        System.out.println("\n"+list.retainAll(list));
        //System.out.println("\n"+list.removeAll(list));
        //list.Iterator, list.listIterator
        //System.out.println("\n"+list.listIterator());
        System.out.println(list.subList(0,2));
        //System.out.println(list.next);
        System.out.println("\n"+list);
        String s = null;
        System.out.println(s);


        return ResponseEntity.ok().body("ok done!");
    }

}
