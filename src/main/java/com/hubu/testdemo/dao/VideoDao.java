package com.hubu.testdemo.dao;

import com.hubu.testdemo.entity.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VideoDao extends JpaRepository<Video,Long>  {
    @Query(value = "select * from video where name like CONCAT('%',?1,'%')", nativeQuery = true)
    List<Video> findVideoByName(String videoName);

    // 根据视频上传的日期先后排序显示数据
    @Query(value = "select * from video where upload_time like CONCAT('%',?1,'%') order by upload_time asc", nativeQuery = true)
    List<Video> findVideoByUploadTime(String uploadTime);

    // 根据视频的大小排序显示数据
    @Query(value = "select * from video where size >= ?1 order by size asc", nativeQuery = true)
    List<Video> findVideoByVideoSize(long size);

    // 查询视频文件的个数
    @Query(value = "select count(*) from video", nativeQuery = true)
    int findVideoAmount();

    //根据视频的名称删除文件
    @Modifying
    @Query(value = "delete from video where name = ?1", nativeQuery = true)
    void deleteVideoByName(String videoName);
}
