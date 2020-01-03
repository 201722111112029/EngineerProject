package com.hubu.testdemo.service;

import com.hubu.testdemo.dao.DocumentDao;
import com.hubu.testdemo.entity.Document;
import com.hubu.testdemo.utils.IOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class DocumentService {
    @Autowired
    private DocumentDao documentDao;
    // 根据文档名称查找相关的图片文件
    public List<Document> findDocumentByName(String documentName) {
        return documentDao.findDocumentByName(documentName);
    }

    // 根据文档上传的日期先后排序显示数据
    public List<Document> findDocumentByUploadTime(String uploadTime) {
        return documentDao.findDocumentByUploadTime(uploadTime);
    }

    // 根据文档的大小排序显示数据
    public List<Document> findDocumentByDocumentSize(long size) {
        return documentDao.findDocumentByDocumentSize(size);
    }

    // 查询当前用户的文档文件数量
    public int findDocumentAmount() {
        return documentDao.findDocumentAmount();
    }

    // 增加文档文件
    public boolean addDocumentFile(Document document) {
        boolean flag = true;
        if (!documentDao.findDocumentByName(document.getName()).isEmpty())
            flag = false;
        else{
            String destinationUrl = "D:\\yunDiskSpace\\document\\"+document.getName();
            String currTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date().getTime());
            File documentContent = new File(document.getSourceUrl());
            document.setUploadTime(currTime);
            document.setSize(documentContent.length());
            document.setDestinationUrl(destinationUrl);
            documentDao.save(document);
            IOUtil ioTool = new IOUtil(document.getSourceUrl(),destinationUrl);
            ioTool.saveResource();
        }
        return flag;
    }

    // 删除文档文件
    public void deleteDocumentFile(String documentName) {
        if (!documentDao.findDocumentByName(documentName).isEmpty()) {
            List<Document> documents = documentDao.findDocumentByName(documentName);
            for(Document document:documents){
                new File(document.getDestinationUrl()).delete();
            }
            documentDao.deleteDocumentByName(documentName);
        }
    }
    //下载文档
    public void downloadDocument(String destinationUrl,String localPath){
        IOUtil util = new IOUtil(destinationUrl,localPath);
        util.saveResource();
    }
}

