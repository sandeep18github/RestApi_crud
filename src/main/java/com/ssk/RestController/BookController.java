package com.ssk.RestController;

import com.ssk.Entity.Book;
import com.ssk.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping("/book")
    public ResponseEntity<String> addBook(@RequestBody Book book) {

        String msg = bookService.upsertBook(book);
        return new ResponseEntity<>(msg, HttpStatus.CREATED);


    }

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> allBooks = bookService.getAllBooks();
        return new ResponseEntity<>(allBooks, HttpStatus.OK);
    }

    @PutMapping("/book")
    public ResponseEntity<String> updateBook(@RequestBody Book book) {
        String msg = bookService.upsertBook(book);
        return new ResponseEntity<>(msg, HttpStatus.OK);


    }

    @DeleteMapping("/book/{bookId}")
    public ResponseEntity<String> deleteBook(@PathVariable Integer bookId) {
        String msg = bookService.deleteBook(bookId);
        return new ResponseEntity<>(msg, HttpStatus.OK);

    }
}
