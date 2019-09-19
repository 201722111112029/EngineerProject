package com.hubu.testdemo;

import javax.transaction.Transactional;

import com.hubu.testdemo.dao.MusicDao;
import com.hubu.testdemo.dao.VideoDao;
import com.hubu.testdemo.entity.Music;
import com.hubu.testdemo.entity.Student;
import com.hubu.testdemo.entity.Video;
import com.hubu.testdemo.service.StudentService;

import com.hubu.testdemo.utils.IOUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit4.SpringRunner;

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

	@Test
	public void contextLoads() {
		Student student = studentService.getStudent(1);
		System.out.println(student);
	}

	@Test
	public void addMusic(){
		//获取当前的时间
		String currTime = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss")
				.format(new Date().getTime());
		//传入存入music表的对象
		Music music = new Music();
		music.setName("许一鸣 - 想你想疯了.mp3");
		//本机传输文件的位置url
		String url = "D:/CloudMusic/许一鸣 - 想你想疯了.mp3";
		File musicContent = new File(url);
		music.setContent(musicContent);//传入File类型的对象musicContent
		music.setSize(musicContent.length());//musicContent.length()获取的是字节数,long类型
		music.setUploadTime(currTime);
		musicDao.save(music);
	}

	@Test
	@Transactional
	public void findMusicById(){
		//packageName 云盘本地保存目录
		File packageName = new File("E:\\HuBuDisk\\music");
		//如果不存在，就在E盘下创建名为HuBuDisk的目录和music二级目录
		if (!packageName.exists()) packageName.mkdirs();
		//从数据库读取相应的文件
		Music music = musicDao.getOne(1L);
		String musicName = music.getName();
		//文件存储的位置
		File file = new File(packageName,musicName);
		File musicContent = music.getContent();
		//调用编辑好的工具类进行文件下载
		IOUtil ioUtil = new IOUtil(musicContent,file);
		ioUtil.saveResource();
	}
	@Test
	public void addVideo(){
		//获取当前时间的字符串
		String currTime = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss")
				.format(new Date().getTime());
		//上传文件的url地址+文件名称+文件类型
		String fileName = "D:/CloudMusic/MV/GALA - 追梦赤子心.mp4";
		File file = new File(fileName);
		Video video = new Video();
		video.setName("GALA - 追梦赤子心.mp4");
		video.setContent(file);
		video.setSize(file.length());
		video.setUploadTime(currTime);
		videoDao.save(video);
	}

	@Test
	@Transactional
	public void findVideoById(){
		//packageName 云盘本地保存目录
		File packageName = new File("E:\\HuBuDisk\\video");
		//如果不存在，就在E盘下创建名为HuBuDisk的目录和music二级目录
		if (!packageName.exists()) packageName.mkdirs();
		//从数据库读取相应的文件
		Video video = videoDao.getOne(2L);
		String videoName = video.getName();
		//文件存储的位置
		File destionationFile = new File(packageName,videoName);
		File videoContent = video.getContent();
		//调用编辑好的工具类进行文件下载
		IOUtil ioUtil = new IOUtil(videoContent,destionationFile);
		ioUtil.saveResource();
	}

}
