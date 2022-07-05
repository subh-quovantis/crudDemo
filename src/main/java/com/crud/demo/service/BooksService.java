package com.crud.demo.service;

import com.crud.demo.model.Books;
import com.crud.demo.repository.BooksRepository;
import com.crud.demo.requestdto.BookRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BooksService {
    @Autowired
    BooksRepository booksRepository;
    public Books getBooksById(int bookId) {

         return booksRepository.findById(bookId).get();
    }

    public Books saveOrUpdate(BookRequestDTO books) {
        Books book1 = new Books();
        book1.setBookId(books.getBookId());
        book1.setBookName(books.getBookName());
        book1.setAuthor(books.getAuthor());
        book1.setPrice(books.getPrice());
        return booksRepository.save(book1);
    }

    public List<Books> getAllBooks() {
//        List<Books> books = new ArrayList<Books>();
//        booksRepository.findAll().forEach(books1 -> books.add(books1));
//        return books;
        return booksRepository.findAll();
    }

    public void deleteBook(int bookid) {
        Books book=this.getBooksById(bookid);
        booksRepository.delete(book);
    }
}
