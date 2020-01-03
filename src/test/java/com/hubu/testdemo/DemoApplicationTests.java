package com.hubu.testdemo;


import com.hubu.testdemo.dao.MusicDao;
import com.hubu.testdemo.dao.VideoDao;
import com.hubu.testdemo.entity.Music;
import com.hubu.testdemo.entity.Video;
import com.hubu.testdemo.service.MusicService;
import com.hubu.testdemo.service.StudentService;
import com.hubu.testdemo.utils.IOUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	private StudentService studentService;

	@Autowired
	private MusicDao musicDao;

	@Autowired
	private VideoDao videoDao;

	@Autowired
	private MusicService musicService;

	@Test
	public void contextLoads() {
	
	}

	@Test
	public void addMusicFile() {
		// 获取当前的时间
		String currTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date().getTime());
		// 传入存入music表的对象
		Music music = new Music();
		music.setName("清水準一 - Bloom of Youth.mp3");
		// 本机传输文件的位置url
		String url = "D:/CloudMusic/清水準一 - Bloom of Youth.mp3";
		File musicContent = new File(url);
		music.setSourceUrl(url);// 传入本地文件路径
		music.setSize(musicContent.length());// musicContent.length()获取的是字节数,long类型
		music.setUploadTime(currTime);
		musicService.addMusicFile(music);
	}

}
