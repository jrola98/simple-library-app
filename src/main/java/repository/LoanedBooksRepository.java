package repository;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import model.Book;
import model.LoanedBooks;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class LoanedBooksRepository {
    private List<Book> loanedBooks;

    public void loanBook (Book book){
        loanedBooks.add(book);
    }

    public void returnBook (Book book){
        loanedBooks.remove(book);
    }
}
