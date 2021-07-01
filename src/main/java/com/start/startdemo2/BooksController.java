package com.start.startdemo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class BooksController {
    @Autowired
    BooksRepository booksRepository;
    @GetMapping("/getbook")
    public ResponseEntity<Optional<Books>> getbook(@RequestParam("id") int id){

         Optional<Books> data = booksRepository.findById(id);
        return ResponseEntity.ok()
                .body(data);
    }
    @PostMapping("/savebook")
    public ResponseEntity<String> postBody(@RequestBody Books book){
        Books books = new Books();

        booksRepository.save(book);
        return ResponseEntity.ok().body("success");
    }
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleterecord(@RequestParam("id") int id){

        booksRepository.deleteById(id);
        return ResponseEntity.ok().body("Successfully deleted");
    }
    @PutMapping("/update")
    public ResponseEntity<Books> updaterecord(@RequestBody Books book){

        Optional<Books> data = booksRepository.findById(book.getBookid());
        data.get().setBookname(book.getBookname());
        booksRepository.save(data.get());
        return ResponseEntity.ok().body(data.get());
    }



}
