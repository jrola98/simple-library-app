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
    private String loanDate;

    public LoanedBooks(long bookId, String loanDate) {
        this.bookId = bookId;
        this.loanDate = loanDate;
    }


    public static LoanedBooks of(LoanedBooksEntity loanedBooksEntity){
         return new LoanedBooks(loanedBooksEntity.getLoanId(),
                                loanedBooksEntity.getBookId(),
                                loanedBooksEntity.getLoanDate());
    }
}
