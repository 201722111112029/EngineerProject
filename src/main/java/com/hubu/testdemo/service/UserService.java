package com.hubu.testdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hubu.testdemo.dao.UserDao;
import com.hubu.testdemo.entity.User;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public User getUser(Long id) {
        return userDao.findById(id).get();
    }

    public boolean checkLegitimacy(String name,String password) {
        boolean flag = false;
        List<User> users = userDao.findUserByName(name);
        for (User user : users) {
            if (user.getPassword().equals(password))
                flag = true;
        }
        return flag;
    }
}