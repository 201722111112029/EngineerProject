package com.hubu.testdemo.entity;

import javax.persistence.*;
import lombok.Data;
<<<<<<< HEAD
/**
 * @Entity：申明实体类
 * @Table(name = "user") 对应数据库user表 实体类与数据库表的对应
 * @Data 用于自动生成setter、getter方法及toString()方法
 * @Id 该属性为数据库的主键
 * @GeneratedValue(strategy = GenerationType.IDENTITY) 主键的生成策略 自增      
 */
@Entity
@Table(name = "user")
@Data

public class User {
=======

@Entity
@Table(name = "user")
@Data
public class User {

>>>>>>> b29f34711a9d9ab55a167b68ad0a4d0c7ef51339
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;
}