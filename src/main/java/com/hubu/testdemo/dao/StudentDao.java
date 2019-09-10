package com.hubu.testdemo.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import com.hubu.testdemo.entity.Student;
public interface StudentDao extends JpaRepository<Student, Integer> {
}