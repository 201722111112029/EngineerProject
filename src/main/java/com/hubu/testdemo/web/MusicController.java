package com.hubu.testdemo.web;

import java.util.List;

import com.hubu.testdemo.entity.Music;
import com.hubu.testdemo.service.MusicService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

public class MusicController {
    @Autowired
    private MusicService musicService;

    // 根据音乐名称查找相关的音乐文件
    @RequestMapping(value = "/findMusicByName", method = RequestMethod.GET)
    public ModelAndView findMusicByName(Model model,@RequestParam("musicName") String musicName) {
        Music music = musicService.findMusicByName(musicName);
        model.addAttribute("music", music);
        return new ModelAndView("music");
    }

    // 根据音乐上传的日期先后排序显示数据
    @RequestMapping(value = "/findMusicByUploadTime", method = RequestMethod.GET)
    public ModelAndView findMusicByUploadTime(Model model,@RequestParam("uploadTime") String uploadTime) {
        List<Music> musics = musicService.findMusicByUploadTime(uploadTime);
        model.addAttribute("musics", musics);
        return new ModelAndView("music");
    }

    // 根据音乐的大小排序显示数据
    @RequestMapping(value = "/findMusicByMusicSize", method = RequestMethod.GET)
    public ModelAndView findMusicByMusicSize(Model model,@RequestParam("size") long size) {
        List<Music> musics =  musicService.findMusicByMusicSize(size);
        model.addAttribute("attributeName", musics);
        return new ModelAndView("music");
    }

    // 查询当前用户的音乐文件数量
    @RequestMapping(value = "/findMusicAmount", method = RequestMethod.GET)
    public ModelAndView findMusicAmount(Model model) {
        int amount = musicService.findMusicAmount();
        model.addAttribute("amount", amount);
        return new ModelAndView("music");
    }

    // 增加音乐文件
    @RequestMapping(value = "/addMusicFile", method = RequestMethod.POST)
    public ModelAndView addMusicFile(Model model, @RequestBody Music music) {
        //增加音乐文件的结果
        boolean flag = true;
        if (musicService.findMusicByName(music.getName()) != null)
            flag = false;
        else
            musicService.addMusicFile(music);
        model.addAttribute("flag", flag);
        return new ModelAndView("music");
    }

    // 删除音乐文件
    @RequestMapping(value = "/deleteMusicFile", method = RequestMethod.DELETE)
    public String deleteMusicFile(@RequestParam("fileName") String fileName) {
        musicService.deleteMusicFile(fileName);
        return "music";
    }
}