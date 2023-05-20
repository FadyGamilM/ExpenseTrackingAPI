package com.backend.expensetrackerapi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.backend.expensetrackerapi.domain.User;

import jakarta.transaction.Transactional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    // // ➜ method to register a new user
    // Long Register(String username, String firstName, String lastName, String
    // email, String password);

    // // ➜ method to login a user (validate if this user exists)
    // User Login(String email, String password);

    // ➜ Get all users from et_users table
    @Query(value = "SELECT * FROM et_users", nativeQuery = true)
    List<User> findAllUsers();

    // ➜ Get User By Id
    User findUserById(Long userId);

    // ➜ Get User By Email, we can use this method in login to check first if we
    // have this email before because mail must be unique per user
    @Query(value = "SELECT * FROM et_users WHERE email = ?1", nativeQuery = true)
    User findUserByEmail(String email);

    // // ➜ Create new user and return the id
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO et_users(username, first_name, last_name, email, password) VALUES (?1, ?2, ?3, ?4, ?5)", nativeQuery = true)
    void CreateUser(String username, String firstName, String lastName, String email, String password);

}