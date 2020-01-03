package com.hubu.testdemo.entity;

import lombok.Data;

import javax.persistence.*;


@Entity
@Table(name = "video")
@Data
public class Video {
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
