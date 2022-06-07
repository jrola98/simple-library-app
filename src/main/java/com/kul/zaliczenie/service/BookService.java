package com.kul.zaliczenie.service;

import com.kul.zaliczenie.model.Book;
import com.kul.zaliczenie.repository.BookRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {

    //crud

    private final BookRepositoryImpl bookRepository;

    public List<Book> loadList() {
        return bookRepository.getBooks();

    }

    public void add(Book book) {
        bookRepository.insertBook(book);
        System.out.println(book);
    }

    public Optional<Book> getBook(String title){
        return bookRepository.getBook(title);
    }

    public void removeBook(long id){
        bookRepository.removeBook(id);
    }


}
