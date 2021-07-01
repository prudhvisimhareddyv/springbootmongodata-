package com.start.startdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class MongoBooksController {
    @Autowired
    MongoBooksRepository booksRepository;
    @GetMapping("/Mongo/getbook")
    public ResponseEntity<Optional<MongoBooks>> getbook(@RequestParam("id") int id){

        Optional<MongoBooks> data = booksRepository.findById(id);
        return ResponseEntity.ok()
                .body(data);
    }
    @PostMapping("/Mongo/savebook")
    public ResponseEntity<String> postBody(@RequestBody MongoBooks book){
        Books books = new Books();

        booksRepository.save(book);
        return ResponseEntity.ok().body("success");
    }
    @DeleteMapping("/Mongo/delete")
    public ResponseEntity<String> deleterecord(@RequestParam("id") int id){

        booksRepository.deleteById(id);
        return ResponseEntity.ok().body("Successfully deleted");
    }
    @PutMapping("/Mongo/update")
    public ResponseEntity<MongoBooks> updaterecord(@RequestBody MongoBooks book){

        Optional<MongoBooks> data = booksRepository.findById(book.get_id());
        data.get().setBookname(book.getBookname());
        booksRepository.save(data.get());
        return ResponseEntity.ok().body(data.get());
    }

}
