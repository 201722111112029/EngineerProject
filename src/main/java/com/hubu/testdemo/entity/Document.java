package com.hubu.testdemo.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.File;

@Entity
@Table(name = "document")
@Data
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String name;

    private String sourceUrl;

    private String destinationUrl;

    private Long size;

    private String uploadTime;
}
