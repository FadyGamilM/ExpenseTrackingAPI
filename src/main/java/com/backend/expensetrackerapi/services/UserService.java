package com.backend.expensetrackerapi.services;

import com.backend.expensetrackerapi.exceptions.ET_AuthException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backend.expensetrackerapi.domain.User;

public interface UserService {
    // ➜ validate if this user exists (used in login)
    User ValidateUser(String email, String password) throws ET_AuthException;

    // ➜ create a new user (used in registeration)
    User CreateUser(String firstName, String lastName, String username, String email, String password)
            throws ET_AuthException;
}