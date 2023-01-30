package com.kul.zaliczenie.model;

import com.kul.zaliczenie.entity.LoanedBooksEntity;
import lombok.*;

@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
@Builder
public class LoanedBooks {

    private long loan_id;
    private long bookId;
    private long userId;
    private String loanDate;

    public LoanedBooks(long bookId, String loanDate, long userId) {
        this.bookId = bookId;
        this.loanDate = loanDate;
        this.userId = userId;
    }


    public static LoanedBooks of(LoanedBooksEntity loanedBooksEntity){
         return new LoanedBooks(loanedBooksEntity.getLoanId(),
                                loanedBooksEntity.getBookId(),
                                loanedBooksEntity.getUserId(),
                                loanedBooksEntity.getLoanDate());
    }
}
