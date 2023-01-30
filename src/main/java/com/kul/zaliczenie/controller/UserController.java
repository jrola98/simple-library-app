package com.kul.zaliczenie.controller;

import com.kul.zaliczenie.model.User;
import com.kul.zaliczenie.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("user")
public class UserController {

    UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    List<User> all(){
        return userService.loadList();
    }

    @GetMapping("/{id}")
    Optional<User> get(@PathVariable long id){
        return userService.getUser(id);
    }

    @PostMapping
    void add(@RequestBody User user){
        userService.addUser(user);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable long id) {
        userService.removeUser(id);
    }

}
