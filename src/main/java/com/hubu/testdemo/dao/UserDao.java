package com.hubu.testdemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hubu.testdemo.entity.User;
/**
 * SpringDataJpa的dao层接口规范
 * JpaRepository<操作的实体类类型, 实体类中主键属性的类型>
 * 封装了基本的CRUD操作
 * JpaSpecificationExecutor<操作的实体类类型>
 * 封装了复杂查询（分页等）
 */


public interface UserDao extends JpaRepository<User, Long> {

}