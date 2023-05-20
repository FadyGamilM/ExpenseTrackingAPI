package com.backend.expensetrackerapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.expensetrackerapi.domain.User;
import com.backend.expensetrackerapi.services.user.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService _service;

    public UserController(UserService service) {
        _service = service;
    }

    // endpoint to return all users
    @GetMapping("/all")
    public List<User> GetAll() {
        return _service.findAllUsers();
    }

    // endpoint to return specific user by id
    @GetMapping("/{id}")
    public User GetById(@PathVariable("id") Long id) {
        return _service.findUserById(id);
    }

    // endpoint to create a new user
    @PostMapping("/new")
    public User CreateUSer(@RequestBody User user) {
        System.out.println(user.getPassword());
        System.out.println(user);
        return _service.CreateUser(user.getFirstName(), user.getLastName(), user.getUsername(), user.getEmail(),
                user.getPassword());
    }
}