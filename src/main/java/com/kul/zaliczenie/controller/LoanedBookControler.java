package com.kul.zaliczenie.controller;


import com.kul.zaliczenie.model.LoanedBooks;
import com.kul.zaliczenie.service.LoanedBookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("book/loan")
public class LoanedBookControler {
     LoanedBookService loanedBookService;

     public LoanedBookControler(LoanedBookService loanedBookService){
          this.loanedBookService=loanedBookService;
     }

     @PostMapping
     void loan(@RequestBody LoanedBooks loanedBooks){
          loanedBookService.add(loanedBooks);
     }

     @GetMapping
     List<LoanedBooks> getAll(){
          return loanedBookService.loanedBooks();
     }

     @DeleteMapping("/{loan_id}")
     void delete(@PathVariable long loan_id){
          loanedBookService.returnBook(loan_id);
     }
}
