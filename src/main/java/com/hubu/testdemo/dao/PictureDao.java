package com.hubu.testdemo.dao;

import com.hubu.testdemo.entity.Picture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PictureDao extends JpaRepository<Picture, Long>, JpaSpecificationExecutor<Picture> {
    // 使用sql查询，需要设置 nativeQuery = true
    // 根据图片名称查找相关的图片文件
    @Query(value = "select * from picture where name like CONCAT('%',?1,'%')", nativeQuery = true)
    List<Picture> findPictureByName(String pictureName);

    // 根据图片上传的日期先后排序显示数据
    @Query(value = "select * from picture where upload_time like CONCAT('%',?1,'%') order by upload_time asc", nativeQuery = true)
    List<Picture> findPictureByUploadTime(String uploadTime);

    // 根据图片的大小排序显示数据
    @Query(value = "select * from picture where size >= ?1 order by size asc", nativeQuery = true)
    List<Picture> findPictureByPictureSize(long size);

    // 查询图片文件的个数
    @Query(value = "select count(*) from picture", nativeQuery = true)
    int findPictureAmount();

    //根据图片的名称删除文件
    @Modifying
    @Query(value = "delete from picture where name = ?1", nativeQuery = true)
    void deletePictureByName(String pictureName);
}
