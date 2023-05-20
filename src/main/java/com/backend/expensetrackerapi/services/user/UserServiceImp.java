package com.backend.expensetrackerapi.services.user;

import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backend.expensetrackerapi.domain.User;
import com.backend.expensetrackerapi.exceptions.ET_AuthException;
import com.backend.expensetrackerapi.repositories.UserRepo;

@Service
@Transactional
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepo _userRepo;

    public UserServiceImp(UserRepo repo) {
        _userRepo = repo;
    }

    @Override
    public User ValidateUser(String email, String password) throws ET_AuthException {
        throw new UnsupportedOperationException("Unimplemented method 'ValidateUser'");
    }

    @Override
    public List<User> findAllUsers() {
        return _userRepo.findAllUsers();
    }

    @Override
    public User findUserById(Long userId) {
        return _userRepo.findUserById(userId);
    }

    @Override
    public User findUserByEmail(String userEmail) {
        return _userRepo.findUserByEmail(userEmail);
    }

    @Override
    public User CreateUser(String username, String firstName, String lastName, String email, String password)
            throws ET_AuthException {
        // check that the email field is not null
        String userEmail = email;
        if (userEmail != null)
            // to normalize the email field
            userEmail = userEmail.toLowerCase();

        // define a regex pattern to validate the emial
        var pattern = Pattern.compile("^(.+)@(.+)$");

        // check that this email matches the pattern
        if (!pattern.matcher(userEmail).matches())
            throw new ET_AuthException("provided email is not valid");

        // check if this email is used before or not
        var emailExists = _userRepo.findUserByEmail(userEmail);
        if (emailExists != null)
            throw new ET_AuthException("provided email is already in use !");

        // now create this user
        _userRepo.CreateUser(username, firstName, lastName, userEmail, password);

        // then fetch this user from db to ensure that its created and persisted and
        var createdUser = _userRepo.findUserByEmail(userEmail);

        // return it to the controller
        if (createdUser != null)
            return createdUser;
        else
            throw new ET_AuthException("error while persisting the user entity !");

    }
}