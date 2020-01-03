package com.hubu.testdemo.service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.hubu.testdemo.dao.MusicDao;
import com.hubu.testdemo.entity.Music;

import com.hubu.testdemo.utils.IOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class MusicService {
    @Autowired
    private MusicDao musicDao;

    // 根据音乐名称查找相关的音乐文件
    public List<Music> findMusicByName(String musicName) {
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
        if (!musicDao.findMusicByName(music.getName()).isEmpty())
            flag = false;
        else{
            String destinationUrl = "D:\\yunDiskSpace\\music\\"+music.getName();
            String currTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date().getTime());
            File musicContent = new File(music.getSourceUrl());
            music.setUploadTime(currTime);
            music.setSize(musicContent.length());
            music.setDestinationUrl(destinationUrl);
            musicDao.save(music);
            IOUtil ioTool = new IOUtil(music.getSourceUrl(),destinationUrl);
            ioTool.saveResource();
        }
        return flag;
    }

    // 删除音乐文件
    public void deleteMusicFile(String musicName) {
        if (!musicDao.findMusicByName(musicName).isEmpty()) {
            List<Music> musics = musicDao.findMusicByName(musicName);
            for(Music music:musics){
                new File(music.getDestinationUrl()).delete();
            }
            musicDao.deleteMusicByName(musicName);
        }
    }
    //下载音乐文件
    public void downloadMusicFile(String destinationUrl,String localPath){
        IOUtil util = new IOUtil(destinationUrl,localPath);
        util.saveResource();
    }
}
