package com.kul.zaliczenie.repository;

import com.kul.zaliczenie.entity.LoanedBooksEntity;
import com.kul.zaliczenie.model.LoanedBooks;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@RequiredArgsConstructor
@Repository
public class LoanedBooksJpaRepository implements LoanedBooksRepository {



    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    @Transactional
    public void loanBook(LoanedBooks loanedBooks){
        entityManager.persist(LoanedBooksEntity.fromLoanedBooksEntity(loanedBooks));
    }

    @Override
    @Transactional
    public void returnBook(long id){
        entityManager.remove(findById(id));
    }


    public List<LoanedBooks> getLoanedBooks(){
        return entityManager.createQuery("SELECT loanedBooksEntity FROM LoanedBooksEntity loanedBooksEntity", LoanedBooksEntity.class)
                .getResultList()
                .stream()
                .map(LoanedBooks::of)
                .collect(Collectors.toList());
    }

    public boolean isLoaned(long book_id){
        return entityManager.createQuery("SELECT loanedBooksEntity FROM LoanedBooksEntity loanedBooksEntity WHERE book_id = :book_id")
                .setParameter("book_id", book_id)
                .getResultList()
                .stream()
                .findFirst().isPresent();
    }

    public LoanedBooksEntity findById(long id){
        return entityManager.find(LoanedBooksEntity.class, id);
    }
}
