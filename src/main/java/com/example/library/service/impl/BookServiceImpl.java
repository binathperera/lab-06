package com.example.library.service.impl;

import com.example.library.service.BookService;
import com.example.library.model.Book;
import com.example.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(String id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(String id, Book book) {
        if (bookRepository.existsById(id)) {
            book.setId(id);
            return bookRepository.save(book);
        }
        return null;
    }

    @Override
    public void deleteBook(String id) {
        bookRepository.deleteById(id);
    }

    @Override
    public List<Book> findBooksByYear(int year) {
        return bookRepository.findByPublicationYear(year);
    }

    @Override
    public String getGenre(String id) {
        Book book = getBookById(id);
        return book != null ? book.getGenre() : null;
    }

    @Override
    public void deleteBooksbyYear(int year) {
        bookRepository.deleteByPublicationYear(year);
    }
}
