package com.hubu.testdemo.web;


import com.hubu.testdemo.entity.Video;
import com.hubu.testdemo.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
public class VideoController {
    @Autowired
    private VideoService videoService;
    //根据视频名字查找对应的视频文件
    @GetMapping(value = "/findVideoByName")
    public List<Video> findVideoByName(@RequestParam("videoName")String videoName) {
        List<Video> videos = videoService.findVideoByName(videoName);
        return videos;
    }
    //根据视频上传日期查找
    @GetMapping(value = "/findVideoByUploadTime")
    public List<Video> findVideoByUploadTime(@RequestParam("uploadTime")String uploadTime) {
        List<Video> videos = videoService.findVideoByUploadTime(uploadTime);
        return  videos;
    }
    //根据视频大小查找视频
    @GetMapping(value = "/findVideoBySize")
    public List<Video> findVideoBySize(@RequestParam("size")long size) {
        List<Video> videos =  videoService.findVideoByVideoSize(size);
        return videos;
    }
    // 查询当前用户的视频文件数量
    @GetMapping(value = "/findVideoAmount")
    public int findVideoAmount() {
        return videoService.findVideoAmount();
    }
    //增加一个视频文件
    @PostMapping(value = "/addVideoFile")
    public boolean addVideo(@RequestParam("sourceUrl")String sourceUrl,@RequestParam("videoName") String videoName) {
        Video video = new Video();
        video.setSourceUrl(sourceUrl);
        video.setName(videoName);
        return videoService.addVideoFile(video);
    }
    //删除指定名称的视频文件
    @DeleteMapping(value = "/deleteVideo")
    @Transactional
    public void deleteVideo(@RequestParam("fileName") String fileName) {
        videoService.deleteVideoFile(fileName);
    }
    @GetMapping("/downloadVideo")
    public void downloadVideo(@RequestParam("destinationUrl") String destinationUrl,@RequestParam("localPath") String localPath){
        videoService.downloadVideo(destinationUrl,localPath);
    }
}
