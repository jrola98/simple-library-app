package com.kul.zaliczenie.repository;

import com.kul.zaliczenie.entity.UserEntity;
import com.kul.zaliczenie.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    List<User> getUsers();
    void createUser(User user);
    Optional<User> getUser(long id);
}
