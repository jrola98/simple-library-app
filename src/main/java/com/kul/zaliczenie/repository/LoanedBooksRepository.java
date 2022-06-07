package com.kul.zaliczenie.repository;

import com.kul.zaliczenie.model.Book;
import com.kul.zaliczenie.model.LoanedBooks;

import java.util.List;

public interface LoanedBooksRepository {
    void loanBook(LoanedBooks loanedBooks);

    void returnBook(long id);

}
