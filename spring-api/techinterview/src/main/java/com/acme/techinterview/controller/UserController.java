package com.acme.techinterview.controller;

import com.acme.techinterview.model.User;
import com.acme.techinterview.repository.UserRepository;
import com.acme.techinterview.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;
//    @Autowired
//    private UserRepository userRepository;

    @GetMapping("/users")
    public Iterable<User> getUsers() {
        return userService.findAll();
    }

    @GetMapping("/users/{userid}")
    public User getUser(@PathVariable String userid) {
        return userService.findUser(userid);
    }

    @PostMapping("/users")
    public User saveUsers(@RequestBody User user) {
        return userService.createUser(user);
    }

    @DeleteMapping("/users/{userid}")
    public void deleteUser(@PathVariable String userid) {
        userService.deleteUser(userid);
    }
}
