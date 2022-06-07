package com.kul.zaliczenie.entity;


import lombok.*;
import com.kul.zaliczenie.model.LoanedBooks;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Table(name = "loaned_books", schema = "public")
public class LoanedBooksEntity {

    @Id
    @Column(name = "loan_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long loanId;
    @Column(name = "book_id")
    private long bookId;
    @Column(name = "loan_date")
    private String loanDate;

    public static LoanedBooksEntity fromLoanedBooksEntity(LoanedBooks loanedBooks){
        return new LoanedBooksEntity(loanedBooks.getLoan_id(), loanedBooks.getBookId(), loanedBooks.getLoanDate());
    }




}
