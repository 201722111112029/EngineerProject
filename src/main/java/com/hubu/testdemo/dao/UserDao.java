package com.hubu.testdemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hubu.testdemo.entity.User;

public interface UserDao extends JpaRepository<User, Long> {

}