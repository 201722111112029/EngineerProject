package com.hubu.testdemo.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.File;
@Entity
@Table(name = "picture")
@Data
public class Picture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Lob
    @Basic(fetch=FetchType.LAZY)
    @Column(name = "content",columnDefinition="longblob", nullable=true)
    private File content;
    @Column(name = "size")
    private long size;
    @Column(name = "upload_time")
    private String uploadTime;
}
