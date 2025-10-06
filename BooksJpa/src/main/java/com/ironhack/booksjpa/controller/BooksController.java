package com.ironhack.booksjpa.controller;

import com.ironhack.booksjpa.model.Books;
import com.ironhack.booksjpa.repository.BooksRepository;
import com.ironhack.booksjpa.dto.UpdateBooksTitleRequest;
import com.ironhack.booksjpa.service.BooksService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public class BooksController {
    private final BooksService booksService;

    public BooksController(BooksService booksService) {
        this.booksService = booksService;
    }
    @GetMapping
    public List<Books> getAll() {
        return booksService.findAll();
    }
    @GetMapping("/{id}")
    public Optional<Books> findById(@PathVariable int id) {
        return booksService.findById(id);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Books create(@RequestBody Books books) {
        return booksService.save(books);
    }

    @PutMapping("/{id}")
    public Books update(@PathVariable int id, @RequestBody Books updatedBooks) {
        return booksService.update(id, updatedBooks);
    }
    @PatchMapping("/{id}/title")
    public Books updateTitle(@PathVariable int id, @RequestBody UpdateBooksTitleRequest request) {
        return booksService.updateTitle(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable int id) {
        booksService.deleteById(id);
    }

}
