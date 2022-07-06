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
    private ResponseEntity<Books> getBooks(@PathVariable("bookid") int bookid){
        try{
            Books response=     booksService.getBooksById(bookid);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }
        catch (Exception e ){
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @PostMapping("/book")
    private ResponseEntity<Books> saveBooks(@Valid @RequestBody BookRequestDTO books){
        Books response = booksService.saveOrUpdate(books);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/book")
    private List<Books> getAllBooks()
    {
        return booksService.getAllBooks();
    }
    @GetMapping("/bookByName/{book_name}")
    private List<Books> getBooksByName(@PathVariable("book_name") String book_name)
    {
//        List<Books> response =  booksService.getBooksByName(book_name);
//        return new ResponseEntity<>(response, HttpStatus.CREATED);
        System.out.println(book_name);
        return booksService.getBooksByName(book_name);
    }
    @DeleteMapping("/book/{bookid}")
    private void deleteBook(@PathVariable("bookid") int bookid)
    {
        booksService.deleteBook(bookid);
    }
}
