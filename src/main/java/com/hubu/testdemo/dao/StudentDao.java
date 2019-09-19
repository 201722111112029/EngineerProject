package com.hubu.testdemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.hubu.testdemo.entity.Student;

import java.util.List;

public interface StudentDao extends JpaRepository<Student, Integer>, JpaSpecificationExecutor<Student> {
    //使用jpql的查询方式进行修改 ，除了@Query注解外，还需添加@Modifying注解
    @Query(value = "update Student set stuName = ?1 , stuAge = ?2 , stuAddress = ?3 where stuNo = ?4 ")
    @Modifying
    void updateStudent(String name, Integer age, String address , Integer no);

    //使用sql查询，需要设置 nativeQuery = true
    @Query(value = "select * from student", nativeQuery = true)
    List<Student> findAllStudents();

    //使用方法名称规则查询，不需要使用注解，但是方法的命名需要按照相关的规则
    Student findByStuName(String name);

    List<Student> findByStuNameLike(String name);

    List<Student> findByStuNameLikeAndStuAddress(String name, String address);
}