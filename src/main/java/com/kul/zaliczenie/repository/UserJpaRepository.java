package com.kul.zaliczenie.repository;

import com.kul.zaliczenie.entity.UserEntity;
import com.kul.zaliczenie.model.User;
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
public class UserJpaRepository implements UserRepository {
    @PersistenceContext
    private final EntityManager entityManager;


    @Override
    public List<User> getUsers() {
        return entityManager.createQuery("SELECT userEntity FROM UserEntity userEntity", UserEntity.class)
                .getResultList()
                .stream()
                .map(User::from)
                .collect(Collectors.toList());
    }

    public Optional<User> getUser(long id){
        return entityManager.createQuery("SELECT userEntity FROM UserEntity userEntityt where id like :custId")
                .setParameter("custId", id)
                .getResultList()
                .stream()
                .findFirst();
    }


    public UserEntity findById(long id) {
        return entityManager.find(UserEntity.class, id);
    }

    @Transactional
    public void createUser(User user){
        entityManager.persist(UserEntity.fromUser(user));
    }
}
