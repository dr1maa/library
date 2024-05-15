package com.example.library.controller;

import com.example.library.model.BookGenre;
import com.example.library.service.BookGenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book-genres")
public class BookGenreController {
    private final BookGenreService bookGenreService;

    @Autowired
    public BookGenreController(BookGenreService bookGenreService) {
        this.bookGenreService = bookGenreService;
    }

    @GetMapping
    public ResponseEntity<List<BookGenre>> getAllBookGenres() {
        List<BookGenre> bookGenres = bookGenreService.getAllBookGenres();
        return new ResponseEntity<>(bookGenres, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookGenre> getBookGenreById(@PathVariable Integer id) {
        BookGenre bookGenre = bookGenreService.getBookGenreById(id)
                .orElseThrow(() -> new RuntimeException("BookGenre not found with id: " + id));
        return new ResponseEntity<>(bookGenre, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BookGenre> createBookGenre(@RequestBody BookGenre bookGenre) {
        BookGenre createdBookGenre = bookGenreService.createBookGenre(bookGenre);
        return new ResponseEntity<>(createdBookGenre, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookGenre> updateBookGenre(@PathVariable Integer id, @RequestBody BookGenre bookGenre) {
        BookGenre updatedBookGenre = bookGenreService.updateBookGenre(id, bookGenre);
        return new ResponseEntity<>(updatedBookGenre, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBookGenre(@PathVariable Integer id) {
        bookGenreService.deleteBookGenre(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
