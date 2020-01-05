package com.hubu.testdemo.web;

import java.util.List;

import com.hubu.testdemo.dao.MusicDao;
import com.hubu.testdemo.entity.Music;
import com.hubu.testdemo.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.transaction.Transactional;

@RestController
public class MusicController {
    @Autowired
    private MusicService musicService;

    @Autowired
    private MusicDao musicDao;

//   根据音乐名称查找相关的音乐文件
//    @RequestMapping(value = "/findMusicByName", method = RequestMethod.GET)
//    public ModelAndView findMusicByName(Model model,@RequestParam("musicName") String musicName) {
//        List<Music> musics = musicService.findMusicByName(musicName);
//        model.addAttribute("musics", musics);
//        return new ModelAndView("music");
//    }
    @GetMapping(value = "/findMusicByName")
    public List<Music> findMusicByName(@RequestParam("musicName")String musicName) {
        List<Music> musics = musicService.findMusicByName(musicName);
        return musics;
    }

//   根据音乐上传的日期先后排序显示数据
//    @RequestMapping(value = "/findMusicByUploadTime", method = RequestMethod.GET)
////    public ModelAndView findMusicByUploadTime(Model model,@RequestParam("uploadTime") String uploadTime) {
////        List<Music> musics = musicService.findMusicByUploadTime(uploadTime);
////        model.addAttribute("musics", musics);
////        return new ModelAndView("music");
////    }
    @GetMapping(value = "/findMusicByUploadTime")
    public List<Music> findMusicByUploadTime(@RequestParam("uploadTime")String uploadTime) {
        List<Music> musics = musicService.findMusicByUploadTime(uploadTime);
        return  musics;
    }

//    // 根据音乐的大小排序显示数据
//    @RequestMapping(value = "/findMusicByMusicSize", method = RequestMethod.GET)
//    public ModelAndView findMusicByMusicSize(Model model,@RequestParam("size") long size) {
//        List<Music> musics =  musicService.findMusicByMusicSize(size);
//        model.addAttribute("attributeName", musics);
//        return new ModelAndView("music");
//    }
    @GetMapping(value = "/findMusicBySize")
    public List<Music> findMusicBySize(@RequestParam("size")long size) {
        List<Music> musics =  musicService.findMusicByMusicSize(size);
        return musics;
    }
//    查询当前用户的音乐文件数量
//    @RequestMapping(value = "/findMusicAmount", method = RequestMethod.GET)
//    public ModelAndView findMusicAmount(Model model) {
//        int amount = musicService.findMusicAmount();
//        model.addAttribute("amount", amount);
//        return new ModelAndView("music");
//    }
    @GetMapping(value = "/findMusicAmount")
    public int findMusicAmount() {
        int amount = musicService.findMusicAmount();
        return amount;
    }
//    // 增加音乐文件
//    @RequestMapping(value = "/addMusicFile", method = RequestMethod.POST)
//    public ModelAndView addMusicFile(Model model, @RequestBody Music music) {
//        //增加音乐文件的结果
//        boolean flag = true;
//        if (musicService.findMusicByName(music.getName()) != null)
//            flag = false;
//        else
//            musicService.addMusicFile(music);
//        model.addAttribute("flag", flag);
//        return new ModelAndView("music");
//    }
    @PostMapping(value = "/addMusic")
    public boolean addMusic(@RequestParam("sourceUrl")String sourceUrl,@RequestParam("musicName") String musicName) {
        //增加音乐文件的结果
        Music music = new Music();
        music.setSourceUrl(sourceUrl);
        music.setName(musicName);
        return musicService.addMusicFile(music);
    }
//    // 删除音乐文件
//    @RequestMapping(value = "/deleteMusicFile", method = RequestMethod.DELETE)
//    public String deleteMusicFile(@RequestParam("fileName") String fileName) {
//        musicService.deleteMusicFile(fileName);
//        return "music";
//    }
    @DeleteMapping(value = "/deleteMusic")
    @Transactional
    public void deleteMusic(@RequestParam("fileName") String fileName) {
        musicService.deleteMusicFile(fileName);
    }

    @GetMapping("/downloadMusic")
    public void downloadMusic(@RequestParam("destinationUrl") String destinationUrl,@RequestParam("localPath") String localPath){
        musicService.downloadMusicFile(destinationUrl,localPath);
    }
    @GetMapping("/findAllMusic")
    public ModelAndView findAllMusic(){
        List<Music> musics = musicDao.findAll();
        ModelAndView mav = new ModelAndView();
        mav.addObject("musics",musics);
        mav.setViewName("wend");
        return mav;
    }
}