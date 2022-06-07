package com.kul.zaliczenie.controller;

import com.kul.zaliczenie.model.Book;
import com.kul.zaliczenie.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("book")
public class BookController {

    BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    List<Book> all() {
        return bookService.loadList();
    }

    @PostMapping
    void add(@RequestBody Book book){
        System.out.println(book);
        bookService.add(book);
    }

    @GetMapping("/{title}")
    Optional<Book> get(@PathVariable String title) {
        return bookService.getBook(title);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable long id){
        bookService.removeBook(id);
    }


}
