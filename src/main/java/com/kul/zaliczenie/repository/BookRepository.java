package com.kul.zaliczenie.repository;

import com.kul.zaliczenie.model.Book;

import java.util.List;

public interface BookRepository {
    List<Book> getBooks();
}
