package com.kul.zaliczenie.controller;


import com.kul.zaliczenie.model.LoanedBooks;
import com.kul.zaliczenie.service.LoanedBookService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("book/loan")
public class LoanedBookControler {
    LoanedBookService loanedBookService;

    public LoanedBookControler(LoanedBookService loanedBookService) {
        this.loanedBookService = loanedBookService;
    }

    @PostMapping
    String loan(@RequestBody LoanedBooks loanedBooks) {
        boolean isLoaned = loanedBookService.add(loanedBooks);
        if(isLoaned){return "Dodano wypożyczenie";}

        return "Książka nie jest dostępna";
    }

    @GetMapping
    List<LoanedBooks> getAll() {
        return loanedBookService.loanedBooks();
    }

    @DeleteMapping("/{loan_id}")
    void delete(@PathVariable long loan_id) {
        loanedBookService.returnBook(loan_id);
    }
}
