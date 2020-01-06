package com.hubu.testdemo.dao;

import com.hubu.testdemo.entity.OtherFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

import javax.transaction.Transactional;

public interface OtherFileDao extends JpaRepository<OtherFile, Long>, JpaSpecificationExecutor<OtherFile> {
    // 使用sql查询，需要设置 nativeQuery = true
    // 根据文件名称查找相关的音乐文件
    @Query(value = "select * from other_file where name like CONCAT('%',?1,'%')", nativeQuery = true)
    List<OtherFile> findOtherFileByName(String otherFileName);

    // 根据文件上传的日期先后排序显示数据
    @Query(value = "select * from other_file where upload_time like CONCAT('%',?1,'%') order by upload_time asc", nativeQuery = true)
    List<OtherFile> findOtherFileByUploadTime(String uploadTime);

    // 根据文件的大小排序显示数据
    @Query(value = "select * from other_file where size >= ?1 order by size asc", nativeQuery = true)
    List<OtherFile> findOtherFileByOtherFileSize(long size);

    // 查询文件文件的个数
    @Query(value = "select count(*) from other_file", nativeQuery = true)
    int findOtherFileAmount();

    //根据文件的名称删除文件
    @Transactional
    @Modifying
    @Query(value = "delete from other_file where name = ?1", nativeQuery = true)
    void deleteOtherFileByName(String otherFileName);
}

