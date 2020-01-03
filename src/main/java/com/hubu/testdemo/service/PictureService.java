package com.hubu.testdemo.service;

import com.hubu.testdemo.dao.PictureDao;
import com.hubu.testdemo.entity.Picture;
import com.hubu.testdemo.utils.IOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class PictureService {
    @Autowired
    private PictureDao pictureDao;
    // 根据图片名称查找相关的图片文件
    public List<Picture> findPictureByName(String pictureName) {
        return pictureDao.findPictureByName(pictureName);
    }

    // 根据图片上传的日期先后排序显示数据
    public List<Picture> findPictureByUploadTime(String uploadTime) {
        return pictureDao.findPictureByUploadTime(uploadTime);
    }

    // 根据图片的大小排序显示数据
    public List<Picture> findPictureByPictureSize(long size) {
        return pictureDao.findPictureByPictureSize(size);
    }

    // 查询当前用户的图片文件数量
    public int findPictureAmount() {
        return pictureDao.findPictureAmount();
    }

    // 增加图片文件
    public boolean addPictureFile(Picture picture) {
        boolean flag = true;
        if (!pictureDao.findPictureByName(picture.getName()).isEmpty())
            flag = false;
        else{
            String destinationUrl = "D:\\yunDiskSpace\\picture\\"+picture.getName();
            String currTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date().getTime());
            File pictureContent = new File(picture.getSourceUrl());
            picture.setUploadTime(currTime);
            picture.setSize(pictureContent.length());
            picture.setDestinationUrl(destinationUrl);
            pictureDao.save(picture);
            IOUtil ioTool = new IOUtil(picture.getSourceUrl(),destinationUrl);
            ioTool.saveResource();
        }
        return flag;
    }

    // 删除图片文件
    public void deletePictureFile(String pictureName) {
        if (!pictureDao.findPictureByName(pictureName).isEmpty()) {
            List<Picture> pictures = pictureDao.findPictureByName(pictureName);
            for (Picture picture:pictures){
                new File(picture.getDestinationUrl()).delete();
            }
            pictureDao.deletePictureByName(pictureName);
        }
    }
    //下载图片
    public void downloadPicture(String destinationUrl,String localPath){
        IOUtil util = new IOUtil(destinationUrl,localPath);
        util.saveResource();
    }
}
