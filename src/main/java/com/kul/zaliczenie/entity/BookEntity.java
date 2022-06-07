package com.kul.zaliczenie.entity;

import com.kul.zaliczenie.model.Book;
import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Table(name = "books", schema = "public")

public class BookEntity {

    @Id
    @Column(name = "book_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "title")
    private String title;
    @Column(name = "author")
    private String author;
    @Column(name = "publish_year")
    private String publishYear;

    public BookEntity(String title, String author, String publishYear){
        this.title=title;
        this.author=author;
        this.publishYear=publishYear;
    }



    public static BookEntity fromBook(Book book){
        return new BookEntity(book.getTitle(), book.getAuthor(), book.getPublishYear());
    }
}
