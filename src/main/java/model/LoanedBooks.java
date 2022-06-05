package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LoanedBooks {
    private String loanDate;
    private int memberId;
    private int bookId;
}
