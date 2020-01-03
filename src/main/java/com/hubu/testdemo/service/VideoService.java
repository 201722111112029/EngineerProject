package com.hubu.testdemo.service;

import com.hubu.testdemo.dao.VideoDao;
import com.hubu.testdemo.entity.Video;
import com.hubu.testdemo.utils.IOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class VideoService {
    @Autowired
    private VideoDao videoDao;
    // 根据视频名称查找相关的音乐文件
    public List<Video> findVideoByName(String videoName) {
        return videoDao.findVideoByName(videoName);
    }

    // 根据视频上传的日期先后排序显示数据
    public List<Video> findVideoByUploadTime(String uploadTime) {
        return videoDao.findVideoByUploadTime(uploadTime);
    }

    // 根据视频的大小排序显示数据
    public List<Video> findVideoByVideoSize(long size) {
        return videoDao.findVideoByVideoSize(size);
    }

    // 查询当前用户的视频文件数量
    public int findVideoAmount() {
        return videoDao.findVideoAmount();
    }
    // 增加视频文件
    public boolean addVideoFile(Video video) {
        boolean flag = true;
        if (!videoDao.findVideoByName(video.getName()).isEmpty())
            flag = false;
        else{
            String currTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date().getTime());
            String destinationUrl = "D:\\yunDiskSpace\\video\\"+video.getName();
            File musicContent = new File(video.getSourceUrl());
            video.setUploadTime(currTime);
            video.setSize(musicContent.length());
            video.setDestinationUrl(destinationUrl);
            videoDao.save(video);
            IOUtil ioTool = new IOUtil(video.getSourceUrl(),destinationUrl);
            ioTool.saveResource();
        }
        return flag;
    }
    public void deleteVideoFile(String videoName) {
        if (!videoDao.findVideoByName(videoName).isEmpty()) {
            List<Video> videos = videoDao.findVideoByName(videoName);
            for(Video video:videos){
                new File(video.getDestinationUrl()).delete();
            }
            videoDao.deleteVideoByName(videoName);
        }
    }
    //下载视频
    public void downloadVideo(String destinationUrl,String localPath){
        IOUtil util = new IOUtil(destinationUrl,localPath);
        util.saveResource();
    }
}
