package com.hubu.testdemo.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.File;

@Entity
@Table(name = "other_file")
@Data
public class OtherFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "content", columnDefinition = "longblob", nullable = true)
    private File content;
    @Column(name = "size")
    private Long size;
    @Column(name = "upload_time")
    private String uploadTime;
}
