package com.kul.zaliczenie.service;

import com.kul.zaliczenie.model.User;
import com.kul.zaliczenie.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> loadList(){
        return userRepository.getUsers();
    }


    public void addUser(User user) {
        userRepository.createUser(user);
    }

    public Optional<User> getUser(long id){
        return userRepository.getUser(id);
    }

    public void removeUser(long id){
        userRepository.removeUser(id);
    }
}
