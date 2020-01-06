package com.hubu.testdemo.dao;

import java.util.List;

import javax.transaction.Transactional;

import com.hubu.testdemo.entity.Music;
import com.hubu.testdemo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface MusicDao extends JpaRepository<Music, Long>, JpaSpecificationExecutor<Student> {
    // 使用sql查询，需要设置 nativeQuery = true
    // 根据音乐名称查找相关的音乐文件
    @Query(value = "select * from music where name like CONCAT('%',?1,'%')", nativeQuery = true)
    List<Music> findMusicByName(String musicName);

    // 根据音乐上传的日期先后排序显示数据
    @Query(value = "select * from music where upload_time like CONCAT('%',?1,'%') order by upload_time asc", nativeQuery = true)
    List<Music> findMusicByUploadTime(String uploadTime);

    // 根据音乐的大小排序显示数据
    @Query(value = "select * from music where size >= ?1 order by size asc", nativeQuery = true)
    List<Music> findMusicByMusicSize(long size);

    // 查询音乐文件的个数
    @Query(value = "select count(*) from music", nativeQuery = true)
    int findMusicAmount();

    //根据音乐的名称删除文件
    @Transactional
    @Modifying
    @Query(value = "delete from music where name = ?1", nativeQuery = true)
    void deleteMusicByName(String musicName);
}
