package com.example.library.service;

import java.util.List;
import com.example.library.model.Book;

public interface BookService {
    List<Book> getAllBooks();

    Book getBookById(String id);

    Book addBook(Book book);

    Book updateBook(String id, Book book);

    void deleteBook(String id);

    List<Book> findBooksByYear(int year);

    String getGenre(String id);

    void deleteBooksbyYear(int year);
}
