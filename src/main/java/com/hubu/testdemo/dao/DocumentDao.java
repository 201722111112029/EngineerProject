package com.hubu.testdemo.dao;

import com.hubu.testdemo.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DocumentDao extends JpaRepository<Document, Long>, JpaSpecificationExecutor<Document> {
// 使用sql查询，需要设置 nativeQuery = true
// 根据图片名称查找相关的图片文件
@Query(value = "select * from document where name like CONCAT('%',?1,'%')", nativeQuery = true)
List<Document> findDocumentByName(String documentName);

// 根据图片上传的日期先后排序显示数据
@Query(value = "select * from document where upload_time like CONCAT('%',?1,'%') order by upload_time asc", nativeQuery = true)
    List<Document> findDocumentByUploadTime(String uploadTime);

// 根据图片的大小排序显示数据
@Query(value = "select * from document where size >= ?1 order by size asc", nativeQuery = true)
    List<Document> findDocumentByDocumentSize(long size);

// 查询图片文件的个数
@Query(value = "select count(*) from document", nativeQuery = true)
    int findDocumentAmount();

//根据图片的名称删除文件
@Modifying
@Query(value = "delete from document where name = ?1", nativeQuery = true)
    void deleteDocumentByName(String documentName);
}
