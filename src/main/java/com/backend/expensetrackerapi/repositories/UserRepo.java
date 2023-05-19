package com.backend.expensetrackerapi.repositories;

import com.backend.expensetrackerapi.domain.User;

public interface UserRepo {
    // // ➜ method to register a new user
    // Long Register(String username, String firstName, String lastName, String
    // email, String password);

    // // ➜ method to login a user (validate if this user exists)
    // User Login(String email, String password);

    // ➜ Get User By Id
    User findById(Long userId);

    // ➜ Get User By Email, we can use this method in login to check first if we
    // have this email before because mail must be unique per user
    User findByEmail(String email);

    // ➜ Create new user and return the id
    Long Create(String username, String firstName, String lastName, String email, String password);

}