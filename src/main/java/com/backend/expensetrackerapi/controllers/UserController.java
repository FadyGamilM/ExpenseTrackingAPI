package com.backend.expensetrackerapi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {
    // endpoint to return all users
    @GetMapping("/all")
    public String GetAll() {
        return "all users";
    }

    // endpoint to return specific user by id
    @GetMapping("/{id}")
    public String GetById(@PathVariable("id") Long id) {
        return Long.toString(id);
    }
}