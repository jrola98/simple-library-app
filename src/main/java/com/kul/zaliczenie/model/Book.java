package com.kul.zaliczenie.model;

import com.kul.zaliczenie.entity.BookEntity;
import lombok.*;

import java.util.UUID;

@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
@Builder
public class Book {

    private long id;
    private String title;
    private String author;
    private String publishYear;

    public Book(String title, String author, String publishYear) {
        this.title = title;
        this.author = author;
        this.publishYear = publishYear;
    }


    public static Book from(BookEntity bookEntity){
        return new Book(bookEntity.getId(),
                        bookEntity.getTitle(),
                        bookEntity.getAuthor(),
                        bookEntity.getPublishYear());
    }
}
