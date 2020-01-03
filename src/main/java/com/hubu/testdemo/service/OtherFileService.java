package com.hubu.testdemo.service;

import com.hubu.testdemo.dao.OtherFileDao;
import com.hubu.testdemo.entity.OtherFile;
import com.hubu.testdemo.utils.IOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
@Service
public class OtherFileService  {
    @Autowired
    private OtherFileDao otherFileDao;

    // 根据其它名称查找相关的音乐文件
    public List<OtherFile> findOtherFileByName(String otherFileName) {
        return otherFileDao.findOtherFileByName(otherFileName);
    }

    // 根据其它上传的日期先后排序显示数据
    public List<OtherFile> findOtherFileByUploadTime(String uploadTime) {
        return otherFileDao.findOtherFileByUploadTime(uploadTime);
    }

    // 根据其它的大小排序显示数据
    public List<OtherFile> findOtherFileByOtherFileSize(long size) {
        return otherFileDao.findOtherFileByOtherFileSize(size);
    }

    // 查询当前用户的其它文件数量
    public int findOtherFileAmount() {
        return otherFileDao.findOtherFileAmount();
    }

    // 增加其它文件
    public boolean addOtherFileFile(OtherFile otherFile) {
        boolean flag = true;
        if (!otherFileDao.findOtherFileByName(otherFile.getName()).isEmpty())
            flag = false;
        else{
            String destinationUrl = "D:\\yunDiskSpace\\otherFile\\"+otherFile.getName();
            String currTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date().getTime());
            File otherFileContent = new File(otherFile.getSourceUrl());
            otherFile.setUploadTime(currTime);
            otherFile.setSize(otherFileContent.length());
            otherFile.setDestinationUrl(destinationUrl);
            otherFileDao.save(otherFile);
            IOUtil ioTool = new IOUtil(otherFile.getSourceUrl(),destinationUrl);
            ioTool.saveResource();
        }
        return flag;
    }

    // 删除其它文件
    public void deleteOtherFileFile(String otherFileName) {
        if (!otherFileDao.findOtherFileByName(otherFileName).isEmpty()) {
            List<OtherFile> otherFiles = otherFileDao.findOtherFileByName(otherFileName);
            for(OtherFile of:otherFiles){
              new File(of.getDestinationUrl()).delete();
            }
            otherFileDao.deleteOtherFileByName(otherFileName);
        }
    }
    //下载其它文件
    public void downloadOtherFile(String destinationUrl,String localPath){
        IOUtil util = new IOUtil(destinationUrl,localPath);
        util.saveResource();
    }
}
