package repository;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import model.Book;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class BookRepository {
    private List<Book> books;


}
