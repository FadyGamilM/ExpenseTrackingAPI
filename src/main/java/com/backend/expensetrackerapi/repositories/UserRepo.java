package com.backend.expensetrackerapi.repositories;

import com.backend.expensetrackerapi.domain.User;

public interface UserRepo {
    // ➜ method to register a new user
    Long Register(String username, String firstName, String lastName, String email, String password);

    // ➜ method to login a user (validate if this user exists)
    User Login(String email, String password);
}