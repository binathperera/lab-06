package com.example.library.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.security.access.prepost.PreAuthorize;
import com.example.library.model.Book;
import com.example.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public Book getBookById(@PathVariable String id) {
        return bookService.getBookById(id);
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/year/{year}")
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public List<Book> getBooksByYear(@PathVariable int year) {
        return bookService.findBooksByYear(year);
    }

    @PostMapping("/add")
    @PreAuthorize("hasRole('ADMIN')")
    public Book addBook(@RequestBody Book book) {
        book.setId(null); // Ensure ID is null for new book
        return bookService.addBook(book);
    }

    @PutMapping("/update/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Book updateBook(@PathVariable String id, @RequestBody Book book) {
        return bookService.updateBook(id, book);
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteBook(@PathVariable String id) {
        bookService.deleteBook(id);
    }

    @DeleteMapping("/delete/year/{year}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteBooksByYear(@PathVariable int year) {
        bookService.deleteBooksbyYear(year);
    }

    @GetMapping("/genre/{id}")
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public String getGenre(@PathVariable String id) {
        return bookService.getGenre(id);
    }

}
