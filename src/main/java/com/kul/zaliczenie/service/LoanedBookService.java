package com.kul.zaliczenie.service;


import com.kul.zaliczenie.model.LoanedBooks;
import com.kul.zaliczenie.repository.LoanedBooksJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LoanedBookService {
    private final LoanedBooksJpaRepository loanedBooksJpaRepository;

    public List<LoanedBooks> loanedBooks() {
        return loanedBooksJpaRepository.getLoanedBooks();
    }

    public void returnBook(long loanId) {
        loanedBooksJpaRepository.returnBook(loanId);
    }

    public boolean add(LoanedBooks loanedBooks) {
        if (loanedBooksJpaRepository.isLoaned(loanedBooks.getBookId())){return false;}
        else {
            loanedBooksJpaRepository.loanBook(loanedBooks);
            return true;
        }


    }
}



