package com.kul.zaliczenie.repository;


import com.kul.zaliczenie.entity.BookEntity;
import com.kul.zaliczenie.model.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Repository
@Primary
public class BookRepositoryImpl implements BookRepository {
    @PersistenceContext
    private final EntityManager entityManager;

    public List<Book> getBooks() {
        return entityManager.createQuery("SELECT bookEntity FROM BookEntity bookEntity", BookEntity.class)
                .getResultList()
                .stream()
                .map(Book::from)
                .collect(Collectors.toList());
    }

    public Optional<Book> getBook(String title){
        return entityManager.createQuery("SELECT bookEntity FROM BookEntity bookEntity WHERE title like :custTitle")
                .setParameter("custTitle", title)
                .getResultList()
                .stream()
                .findFirst();
    }

    public BookEntity findById(long id){

        return entityManager.find(BookEntity.class, id);
    }
    @Transactional
    public void removeBook(long id){
        entityManager.remove(findById(id));
    }

    @Transactional
    public void insertBook(Book book){
        entityManager.persist(BookEntity.fromBook(book));
    }




}
