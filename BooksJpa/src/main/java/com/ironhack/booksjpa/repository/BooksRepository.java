package com.ironhack.booksjpa.repository;

import com.ironhack.booksjpa.model.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BooksRepository extends JpaRepository<Books, Integer> {

    List<Books> findAll();
    List<Books> findAllById(Iterable<Integer> integers);
    List<Books> findByAuthor(String author);                       // 1
    List<Books> findByGenreAndPublisher(String genre, String publisher); // 2
    List<Books> findByReleaseDateAfter(LocalDate date);            // 3

    @Query("SELECT b FROM Books b WHERE b.title LIKE %:keyword%")
    List<Books> findBooksByTitleContains(String keyword);

    @Query(value = "SELECT * FROM Books b ORDER BY b.releaseDate ASC", nativeQuery = true)
    List<Books> findAllByReleaseDateOrderByReleaseDateDesc();

    @Query(value = "SELECT * FROM BOOKS b WHERE b.author LIKE 'Van%' ", nativeQuery = true)
    List<Books> findAllByAuthorLike();
}
