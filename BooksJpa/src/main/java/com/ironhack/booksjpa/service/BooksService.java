package com.ironhack.booksjpa.service;

import com.ironhack.booksjpa.repository.BooksRepository;
import com.ironhack.booksjpa.model.Books;
import com.ironhack.booksjpa.dto.UpdateBooksTitleRequest;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class BooksService {public final BooksRepository booksRepository;

    public BooksService(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    @PostConstruct
    private void init() {
        System.out.println("Initialising db...");

        Books books1 =  new Books("LOTR", "Vanessa A", "Klett", "Fantasy", LocalDate.of(2001,10,10));

        Books books2 =  new Books("Harry Potter", "Vanessa B", "J K Rowling", "Fantasy", LocalDate.of(1990,5,1));

        Books books3 =  new Books("Artemis Fowl", "Eoin Colfer", "Colfer", "Kids", LocalDate.of(1992    ,10,10));
        booksRepository.saveAll(List.of(books1, books2, books3));
    }
    public List<Books> findAll() {
        System.out.println("Finding all books...");
        return booksRepository.findAll();
    }

    public Optional<Books> findById(Integer id) {
        System.out.println("Finding Books with id: " + id);
        Optional<Books> optionalBooks = booksRepository.findById(id);
        if  (optionalBooks.isPresent()) {
            Books books = optionalBooks.get();
            System.out.println("Found Book: " + books.getTitle());
        } else {
            System.out.println("Book with id: " + id + " not found");
        }
        return optionalBooks;
    }

    public Books save(Books books) {
        System.out.println("Saving books..." + books.getTitle());
        return booksRepository.save(books);
    }

    public Books update(int id, Books updatedBooks) {
        Books booksToUpdate = booksRepository.findById(id).orElseThrow(
                ( ) -> new RuntimeException("Book with id: " + id + " not found"));

        booksToUpdate.setTitle(updatedBooks.getTitle());
        booksToUpdate.setAuthor(updatedBooks.getAuthor());
        booksToUpdate.setPublisher(updatedBooks.getPublisher());
        booksToUpdate.setGenre(updatedBooks.getGenre());
        booksToUpdate.setReleaseDate(updatedBooks.getReleaseDate());

        return booksRepository.save(booksToUpdate);
    }

    public Books updateTitle(int id, UpdateBooksTitleRequest request) {
        if (id != request.getId()) {
            throw new IllegalArgumentException("Id in path and request body do not match");
        }
        Books booksToUpdate = booksRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Book with id: " + id + " not found"));

        booksToUpdate.setTitle(request.getTitle());
        return booksRepository.save(booksToUpdate);
    }
    public void deleteById(int id) {
        booksRepository.deleteById(id);
    }
}
