package com.hubu.testdemo.web;

import com.hubu.testdemo.entity.Picture;
import com.hubu.testdemo.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
public class PictureController {
    @Autowired
    private PictureService pictureService;
    //根据名称查找图片
    @GetMapping(value = "/findPictureByName")
    public List<Picture> findPictureByName(@RequestParam("pictureName")String pictureName) {
        List<Picture> pictures = pictureService.findPictureByName(pictureName);
        return pictures;
    }

    @GetMapping(value = "/findPictureByUploadTime")
    public List<Picture> findPictureByUploadTime(@RequestParam("uploadTime")String uploadTime) {
        List<Picture> pictures = pictureService.findPictureByUploadTime(uploadTime);
        return  pictures;
    }

    @GetMapping(value = "/findPictureBySize")
    public List<Picture> findPictureBySize(@RequestParam("size")long size) {
        List<Picture> pictures =  pictureService.findPictureByPictureSize(size);
        return pictures;
    }

    @GetMapping(value = "/findPictureAmount")
    public int findPictureAmount() {
        int amount = pictureService.findPictureAmount();
        return amount;
    }

    @PostMapping(value = "/addPicture")
    public boolean addPicture(@RequestParam("sourceUrl")String sourceUrl, @RequestParam("pictureName") String pictureName) {
        //增加音乐文件的结果
        Picture picture = new Picture();
        picture.setSourceUrl(sourceUrl);
        picture.setName(pictureName);
        return pictureService.addPictureFile(picture);
    }

    @DeleteMapping(value = "/deletePicture")
    @Transactional
    public void deletePicture(@RequestParam("fileName") String fileName) {
        pictureService.deletePictureFile(fileName);
    }
    @GetMapping("/downloadPicture")
    public void downloadOtherFile(@RequestParam("destinationUrl") String destinationUrl,@RequestParam("localPath") String localPath){
        pictureService.downloadPicture(destinationUrl,localPath);
    }
}
