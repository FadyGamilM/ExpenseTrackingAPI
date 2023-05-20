package com.backend.expensetrackerapi.services.user;

import com.backend.expensetrackerapi.exceptions.ET_AuthException;

import java.util.List;

import com.backend.expensetrackerapi.domain.User;

public interface UserService {
    // ➜ validate if this user exists (used in login)
    User ValidateUser(String email, String password) throws ET_AuthException;

    // ➜ create a new user (used in registeration)
    User CreateUser(String username, String firstName, String lastName, String email, String password)
            throws ET_AuthException;

    // ➜ find all users service
    List<User> findAllUsers();

    // ➜ find user by id service
    User findUserById(Long userId);

    // ➜ find user by email service
    User findUserByEmail(String userEmail);
}