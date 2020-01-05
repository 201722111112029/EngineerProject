package com.hubu.testdemo;

import com.hubu.testdemo.entity.Music;
import com.hubu.testdemo.entity.Video;
import com.hubu.testdemo.service.MusicService;
import com.hubu.testdemo.service.VideoService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	private VideoService videoService;

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

	@Test
	public void findMusicByName(){
		List<Music> musics = musicService.findMusicByName("川井憲次 - 孤独な巡礼.mp3");
		boolean flag = false;
		for (Music music:musics){
			long id = music.getId();
			if (id==3){
				flag = true;
			}
		}
		Assert.assertEquals(true,flag);
	}

	@Test
	public void addMusic(){
		Music music = new Music();
		music.setSourceUrl("C:\\Users\\Mr Zheng\\Music\\薛之谦 - 演员.mp3");
		music.setName("薛之谦 - 演员.mp3");
		boolean isExist = musicService.addMusicFile(music);
		Assert.assertEquals(true,isExist);
	}

	@Test
	public void findMusicByUploadTime(){
		List<Music> musics = musicService.findMusicByUploadTime("2019-12-31");
		Assert.assertEquals(4,musics.size());
	}

	@Test
	public void deleteMusicByName(){
		musicService.deleteMusicFile("川井憲次 - 孤独な巡礼.mp3");
	}

	@Test
	public void downloadMusic(){
		musicService.downloadMusicFile("D:\\yunDiskSpace\\music磯村由紀子 - 風の住む街.mp3","E:\\HuBuDisk\\music\\testMusic.mp3");
		Assert.assertEquals(true,new File("E:\\HuBuDisk\\music\\testMusic.mp3").exists());
	}

	@Test
	public void addVideo(){
		Video video = new Video();
		video.setSourceUrl("C:\\Users\\Mr Zheng\\Videos\\Captures\\video1.mp4");
		video.setName("video1.mp4");
		Assert.assertEquals(true,videoService.addVideoFile(video));
	}

	@Test
	public void findVideoByName(){
		Video video = new Video();
		video.setName("video1.mp4");
		video.setSourceUrl("C:\\Users\\Mr Zheng\\Videos\\Captures\\video1.mp4");
		video.setDestinationUrl("D:\\yunDiskSpace\\video\\video1.mp4");
		video.setSize(5235345L);
		video.setUploadTime("2020-01-05 10:21:09");
		Assert.assertEquals(video,videoService.findVideoByName("video1.mp4").get(1));
	}

}
