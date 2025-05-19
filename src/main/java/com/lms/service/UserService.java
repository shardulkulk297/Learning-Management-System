package com.lms.service;

import com.lms.dao.UserDao;
import com.lms.dao.impl.UserDaoImpl;
import com.lms.exception.UserNotFoundException;
import com.lms.model.User;

public class UserService {

    public User signIn(String username, String password){

        if(username == null || password == null){
            throw new NullPointerException("Username or Password cannot be null");
        }

        UserDao userDao = new UserDaoImpl();
        boolean userExists = userDao.signIn(username, password);

        if(userExists){
            return userDao.getUserByUsername(username);
        }
        else{
            throw new UserNotFoundException("Check your credentials!");
        }

    }

    public void signUp(User user){

        if(user == null){
            throw new NullPointerException("User cannot be null");
        }
        if(user.getName() == null || user.getPassword() == null){
            throw new NullPointerException("Username or Password cannot be null");
        }
        UserDao userDao = new UserDaoImpl();
        userDao.signUp(user);
    }



}
