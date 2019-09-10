package com.hubu.testdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hubu.testdemo.dao.StudentDao;
import com.hubu.testdemo.entity.Student;

@Service
public class StudentService {

    @Autowired
    private StudentDao studentDao;

    public Student getStudent(Integer id) {
        return studentDao.getOne(id);
    }
}