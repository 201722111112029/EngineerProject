package com.hubu.testdemo.entity;
import javax.persistence.*;
import lombok.Data;
@Entity
@Table(name = "student")
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer stuno;

    private String stuname;

    private Integer stuage;

    private String stuAddress;
}