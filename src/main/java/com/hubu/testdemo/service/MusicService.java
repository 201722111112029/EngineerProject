package com.hubu.testdemo.service;

import java.util.List;

import com.hubu.testdemo.dao.MusicDao;
import com.hubu.testdemo.entity.Music;

import org.springframework.beans.factory.annotation.Autowired;

public class MusicService {
    @Autowired
    private MusicDao musicDao;

    // 根据音乐名称查找相关的音乐文件
    public Music findMusicByName(String musicName) {
        return musicDao.findMusicByName(musicName);
    }

    // 根据音乐上传的日期先后排序显示数据
    public List<Music> findMusicByUploadTime(String uploadTime) {
        return musicDao.findMusicByUploadTime(uploadTime);
    }

    // 根据音乐的大小排序显示数据
    public List<Music> findMusicByMusicSize(long size) {
        return musicDao.findMusicByMusicSize(size);
    }

    // 查询当前用户的音乐文件数量
    public int findMusicAmount() {
        return musicDao.findMusicAmount();
    }

    // 增加音乐文件
    public boolean addMusicFile(Music music) {
        boolean flag = true;
        if (musicDao.findMusicByName(music.getName()) != null)
            flag = false;
        else
            musicDao.save(music);
        return flag;
    }

    // 删除音乐文件
    public void deleteMusicFile(String musicName) {
        if (musicDao.findMusicByName(musicName) != null) {
            musicDao.deleteMusicByName(musicName);
        }
    }
}
