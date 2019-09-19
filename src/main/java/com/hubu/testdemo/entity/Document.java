package com.hubu.testdemo.entity;

import lombok.Data;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;
import org.springframework.boot.autoconfigure.web.ResourceProperties;

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
    @Column(name = "name")
    private String name;
    @Lob
    @Basic(fetch=FetchType.LAZY)
    @Column(name = "content",columnDefinition="longblob", nullable=true)
    private File content;
    @Column(name = "size")
    private Long size;
    @Column(name = "upload_time")
    private String uploadTime;
}
