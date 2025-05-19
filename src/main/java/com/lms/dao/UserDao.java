package com.lms.dao;

import com.lms.exception.UserNotFoundException;
import com.lms.model.User;

public interface UserDao {

    void signUp(User user);
    boolean signIn(String username, String password) throws UserNotFoundException;
    User getUserByUsername(String username) throws UserNotFoundException;
    boolean isUsernameAvailable(String username);
}
