package com.crud.demo.controller;

import com.crud.demo.model.Books;
import com.crud.demo.requestdto.BookRequestDTO;
import com.crud.demo.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class BookController {
    @Autowired
    BooksService booksService;

    @GetMapping("/book/{bookid}")
    private Books getBooks(@PathVariable("bookid") int bookid){
        return booksService.getBooksById(bookid);
    }
    @PostMapping("/book")
    private ResponseEntity<Books> saveBooks(@Valid @RequestBody BookRequestDTO books){
        Books response = booksService.saveOrUpdate(books);
//        return books.getBookName();
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/book")
    private List<Books> getAllBooks()
    {
        return booksService.getAllBooks();
    }
    @DeleteMapping("/book/{bookid}")
    private void deleteBook(@PathVariable("bookid") int bookid)
    {
        booksService.deleteBook(bookid);
    }
}
