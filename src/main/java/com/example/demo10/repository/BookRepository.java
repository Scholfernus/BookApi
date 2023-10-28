package com.example.demo10.repository;

import com.example.demo10.model.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<BookModel, Long> {

    List<BookModel> findByAuthor(String author);

    @Query("SELECT a FROM BookModel a WHERE a.author = :author")
    List<BookModel> findBookByAuthor(@Param("author") String author);

    List<BookModel> findByPublicationYear(Integer publicationYear);

    @Query("SELECT y FROM BookModel y WHERE y.publicationYear = :publicationYear")
    List<BookModel> findBookByYear(@Param("publicationYear") Integer year);

    List<BookModel> findByTitle(String title);

    @Query("SELECT b FROM BookModel b WHERE b.title = :title")
    List<BookModel>findBookByTitle(@Param("title") String title);

    List<BookModel> findByAuthorStartingWith(String letter);

    List<BookModel> findAllByPublicationYearBefore(Integer given);

}
