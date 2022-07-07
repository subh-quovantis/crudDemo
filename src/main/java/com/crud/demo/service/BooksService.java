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

    public Books saveBooks(BookRequestDTO books) {
        Books book1 = new Books();
        book1.setBook_id(books.getBookId());
        book1.setBook_name(books.getBookName());
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

    public List<Books> getBooksByName(String book_name) {
        List<Books> response = booksRepository.getBooksByName(book_name);
        response.forEach(e-> System.out.println(e.toString()));
        return response;
    }
    public Books updateBooks(Books books) {
        Books book1 = new Books();
        Books book =  booksRepository.getBooksById(books.getBook_id());

        if(book.getBook_name()!=null){
            book.setBook_id(books.getBook_id());
            book.setBook_name(books.getBook_name());
            book.setAuthor(books.getAuthor());
            book.setPrice(books.getPrice());
            return booksRepository.save(book);
        }
        else
        return null;
    }
}
