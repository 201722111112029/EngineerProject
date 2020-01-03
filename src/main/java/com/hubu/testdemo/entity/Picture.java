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

    private String name;

    private String sourceUrl;

    private String destinationUrl;

    private long size;

    private String uploadTime;
}
