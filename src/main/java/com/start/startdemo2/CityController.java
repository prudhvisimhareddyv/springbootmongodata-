package com.start.startdemo2;

import com.mysql.cj.x.protobuf.MysqlxCrud;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class CityController {

    //GET
    //city name as input
    //return data from db

    //GET
    //zipcode and city name as input
    //return data from db

    @Autowired
    CityRepository cityrepo;
    @PostMapping("/city")
    public ResponseEntity<HashSet<City>> citygo(@RequestBody List<City> body) {
        HashSet<City> hashSet = new HashSet(body);
       // JSONObject json = new JSONObject();
        //json.put("hashset",hashSet);
        cityrepo.insert(hashSet);
       // cityrepo.saveAll(hashSet);
        //new HashSet<>(Arrays.asList("a", "b"))
        return ResponseEntity.ok().body(hashSet);

    }
    @GetMapping("/Mongo/citydetails")
    public ResponseEntity<Optional<City>> getbook(@RequestParam("id") int id){

        Optional<City> data = cityrepo.findById(id);
        return ResponseEntity.ok()
                .body(data);
    }
    @DeleteMapping("/Mongo/citydelete")
    public ResponseEntity<String> deleterecord(@RequestParam("id") int id){

        cityrepo.deleteById(id);
        return ResponseEntity.ok().body("Successfully deleted");
    }
    @PutMapping("/Mongo/cityupdate")
    public ResponseEntity<City> updaterecord(@RequestBody City city){

        Optional<City> data = cityrepo.findById(city.get_id());
        data.get().setCityname(city.getCityname());
        cityrepo.save(data.get());
        return ResponseEntity.ok().body(data.get());
    }
    @GetMapping("/Mongo/citydetails1")
    public ResponseEntity<Optional<List<City>>> getbook(@RequestParam("cityname") String cityname){

       Optional<List<City>> data = cityrepo.findBycityname(cityname);
        return ResponseEntity.ok()
                .body(data);
    }
    @GetMapping("/Mongo/citydetails2")
    public ResponseEntity<Optional<List<City>>> getbook(@RequestParam("cityname") String cityname,@RequestParam("zipcode") int zipcode){

        Optional<List<City>> data = cityrepo.findCityBycitynameAndzipcode(cityname,zipcode);
        return ResponseEntity.ok()
                .body(data);
    }
  //Zipcode >0 Zipcode< 1000000
  @GetMapping("/Mongo/citydetails3")
  public ResponseEntity<Optional<List<City>>> getbook(@RequestParam("zipcode1") int zipcode1,@RequestParam("zipcode2") int zipcode2){

      Optional<List<City>> data = cityrepo.findCityByZipcodeRange(zipcode1,zipcode2);
      return ResponseEntity.ok()
              .body(data);
  }
    @GetMapping("/Mongo/allcitydetails")
    public ResponseEntity<List<City>> getbook( )
    {

        List<City> data = cityrepo.findAll();
        return ResponseEntity.ok()
                .body(data);
    }
    @GetMapping("/Mongo/citydetails4")
    public ResponseEntity<Optional<List<City>>> getbook(@RequestParam("cityname1") String cityname1,@RequestParam("cityname2") String cityname2){

        Optional<List<City>> data = cityrepo.findCityBycityname(cityname1,cityname2);
        return ResponseEntity.ok()
                .body(data);
    }
    @GetMapping("/Mongo/citydetailslist")
    public ResponseEntity<Optional<List<City>>> getbooks(@RequestParam("cityname1") String cityname1,@RequestParam("cityname2") String cityname2){
        List citys = new LinkedList();
        citys.add(cityname1);
        citys.add(cityname2);
        Optional<List<City>> data = cityrepo.findCityBycitynamelist(citys);
        return ResponseEntity.ok()
                .body(data);
    }

    @GetMapping("/Mongo/citydetailscount")
    public ResponseEntity<Integer> getbookcount(@RequestParam("cityname1") String cityname1){

        int data = cityrepo.findCityBycitynamecount(cityname1);
        return ResponseEntity.ok()
                .body(data);
    }
    @GetMapping("/Mongo/citydetailsxyz")
    public ResponseEntity<Optional<List<City>>> getbookxyz(@RequestParam("cityname1") String cityname1){

        Optional<List<City>> data = cityrepo.findBycitynamexyz(cityname1);
        return ResponseEntity.ok()
                .body(data);
    }
    @PostMapping("/cityallequal")
    public ResponseEntity<HashSet<City>> citygoall(@RequestBody List<City> body) {
        if(City.set==0) {
            HashSet<City> hashSet = new HashSet<City>(body);
            return ResponseEntity.status(400).body(hashSet);
        }
        else{
            HashSet<City> hashSet = new HashSet<City>(body);
            cityrepo.saveAll(hashSet);
            return ResponseEntity.ok().body(hashSet);
        }
    }
}
