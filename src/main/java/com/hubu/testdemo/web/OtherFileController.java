package com.hubu.testdemo.web;

import com.hubu.testdemo.entity.OtherFile;
import com.hubu.testdemo.service.OtherFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
@RestController
public class OtherFileController {
    @Autowired
    private OtherFileService otherFileService;


    @GetMapping(value = "/findOtherFileByName")
    public List<OtherFile> findOtherFileByName(@RequestParam("otherFileName")String otherFileName) {
        List<OtherFile> otherFiles = otherFileService.findOtherFileByName(otherFileName);
        return otherFiles;
    }

    @GetMapping(value = "/findOtherFileByUploadTime")
    public List<OtherFile> findOtherFileByUploadTime(@RequestParam("uploadTime")String uploadTime) {
        List<OtherFile> otherFiles = otherFileService.findOtherFileByUploadTime(uploadTime);
        return  otherFiles;
    }

    @GetMapping(value = "/findOtherFileBySize")
    public List<OtherFile> findOtherFileBySize(@RequestParam("size")long size) {
        List<OtherFile> otherFiles =  otherFileService.findOtherFileByOtherFileSize(size);
        return otherFiles;
    }

    @GetMapping(value = "/findOtherFileAmount")
    public int findOtherFileAmount() {
        int amount = otherFileService.findOtherFileAmount();
        return amount;
    }

    @PostMapping(value = "/addOtherFile")
    public boolean addOtherFile(@RequestParam("sourceUrl")String sourceUrl, @RequestParam("otherFileName") String otherFileName) {
        //增加音乐文件的结果
        OtherFile otherFile = new OtherFile();
        otherFile.setSourceUrl(sourceUrl);
        otherFile.setName(otherFileName);
        return otherFileService.addOtherFileFile(otherFile);
    }

    @DeleteMapping(value = "/deleteOtherFile")
    @Transactional
    public void deleteOtherFile(@RequestParam("fileName") String fileName) {
        otherFileService.deleteOtherFileFile(fileName);
    }
    @GetMapping("/downloadOtherFile")
    public void downloadOtherFile(@RequestParam("destinationUrl") String destinationUrl,@RequestParam("localPath") String localPath){
        otherFileService.downloadOtherFile(destinationUrl,localPath);
    }
}