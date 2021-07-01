package com.start.startdemo2;

import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

@RestController
public class Homecontroller {
    @DeleteMapping("/12")
    public String homepaging(){
        return "Homepage";
    }


    @GetMapping("/")
    public String getAllheaders(@RequestHeader Map<String,String> headers,@RequestParam("name") String name,@RequestParam("lastname") String lastname) {
        headers.forEach((key,value) ->{
            System.out.println("Header Name: "+key+" Header Value: "+value);
        });


        return " hi this is"+ headers.get("name") +"hi this is"+ headers.get("names") +"hi this is"+ name +"hi this is"+lastname  ;
    }

        @PostMapping("/json")
        public ResponseEntity<Person> postBody(@RequestBody Person person) {
            HttpHeaders responseHeaders = new HttpHeaders();
            responseHeaders.set("Baeldung-Example-Header",
                    "Value-ResponseEntityBuilderWithHttpHeaders");
            responseHeaders.set("Applicationname",
                    "Startdemo");


            return ResponseEntity.ok()
                    .headers(responseHeaders)
                    .body(person);

            //return new ResponseEntity<>("Hello I'm in" +person.getAddress().getLines().getLine1()+ "My city is"+person.getAddress().getCity(), HttpStatus.CREATED).headers(responseHeaders);
        }






    @GetMapping("/1")
    public int homepagingNum(){
        return 1;
    }
}
