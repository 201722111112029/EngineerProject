package com.hubu.testdemo.entity;

import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "student")
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="stu_no")
    private Integer stuNo;
    @Column(name="stu_name")
    private String stuName;
    @Column(name="stu_age")
    private Integer stuAge;
    @Column(name="stu_address")
    private String stuAddress;
}