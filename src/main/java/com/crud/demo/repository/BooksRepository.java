package com.crud.demo.repository;

import com.crud.demo.model.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BooksRepository extends JpaRepository<Books, Integer> {


    @Query("select u from Books u where u.book_name=:n")
    public List<Books> getBooksByName(@Param("n") String book_name);

    @Query("select u from Books u where u.book_id=:n")
    public Books getBooksById(@Param("n") int book_id);
}
