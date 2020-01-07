package com.hubu.testdemo;

import com.hubu.testdemo.entity.Document;
import com.hubu.testdemo.entity.Music;
import com.hubu.testdemo.entity.OtherFile;
import com.hubu.testdemo.entity.Picture;
import com.hubu.testdemo.entity.Video;
import com.hubu.testdemo.service.DocumentService;
import com.hubu.testdemo.service.MusicService;
import com.hubu.testdemo.service.OtherFileService;
import com.hubu.testdemo.service.PictureService;
import com.hubu.testdemo.service.VideoService;
import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	private VideoService videoService;
	@Autowired
	private PictureService pictureService;
	@Autowired
	private OtherFileService otherFileService;
	@Autowired
	private DocumentService documentService;

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
	@Test
	public void adddoucument(){
		Document document =new Document();
		document.setName("1.txt");
		document.setSourceUrl("C:\\Users\\123\\Desktop\\text\\1.txt");
		assertEquals(true,documentService.addDocumentFile(document));
		
	}
	@Test
	public void findDocumentByName() {
		Document document =new Document();
		document.setId(1L);
		document.setName("1.txt");
		document.setSourceUrl("C:\\Users\\123\\Desktop\\text\\1.txt");
		document.setDestinationUrl("D:\\yunDiskSpace\\document\\1.txt");
		document.setSize(131L);
		document.setUploadTime("2020-01-06 17:02:25");
		assertEquals(document, documentService.findDocumentByName("1.txt").get(0));

	}
	@Test
	public void findDocumentByUploadTime() {
		Document document =new Document();
		document.setId(1L);
		document.setName("1.txt");
		document.setSourceUrl("C:\\Users\\123\\Desktop\\text\\1.txt");
		document.setDestinationUrl("D:\\yunDiskSpace\\document\\1.txt");
		document.setSize(131L);
		document.setUploadTime("2020-01-06 17:02:25");
		assertEquals(document, documentService.findDocumentByUploadTime("2020-01-06 17:02:25").get(0));
		
	}
	@Test
        
	public void findDocumentByDocumentSize () {
		Document document =new Document();
		document.setId(1L);
		document.setName("1.txt");
		document.setSourceUrl("C:\\Users\\123\\Desktop\\text\\1.txt");
		document.setDestinationUrl("D:\\yunDiskSpace\\document\\1.txt");
		document.setSize(131L);
		document.setUploadTime("2020-01-06 17:02:25");
		assertEquals(document, documentService.findDocumentByDocumentSize(131L).get(0));
	}
	@Test
	public void findDocumentAmount() {
		assertEquals(1, documentService.findDocumentAmount());
		
	}
	@Test
	public void deleteDocumentFileByName() {
		documentService.deleteDocumentFile("1.txt");
		
	}
	@Test
	public void downloadDocument() {
		documentService.downloadDocument("D:\\yunDiskSpace\\document\\1.txt", "C:\\Users\\123\\Desktop\\text\\2.txt");
		assertEquals(true, new File("C:\\Users\\123\\Desktop\\text\\2.txt").exists());
		
	}
	@Test
	public void addPicture(){
		Picture picture =new Picture();
		picture.setName("2.png");
		picture.setSourceUrl("C:\\Users\\123\\Desktop\\text\\2.png");
		assertEquals(true,pictureService.addPictureFile(picture));
		
	}
	@Test
	public void findPictureByName() {
		Picture picture =new Picture();
		picture.setId(2L);
		picture.setName("2.png");
		picture.setSourceUrl("C:\\Users\\123\\Desktop\\text\\2.png");
		picture.setDestinationUrl("D:\\yunDiskSpace\\picture\\2.png");
		picture.setSize(498274L);
		picture.setUploadTime("2020-01-06 21:25:55");
		assertEquals(picture, pictureService.findPictureByName("2.png").get(0));

	}
	@Test
	public void findPictureByUploadTime() {
		Picture picture =new Picture();
		picture.setId(2L);
		picture.setName("2.png");
		picture.setSourceUrl("C:\\Users\\123\\Desktop\\text\\2.png");
		picture.setDestinationUrl("D:\\yunDiskSpace\\picture\\2.png");
		picture.setSize(498274L);
		picture.setUploadTime("2020-01-06 21:25:55");
		assertEquals(picture, pictureService.findPictureByUploadTime("2020-01-06 21:25:55").get(0));
		
	}
	@Test
        
	public void findPictureByPictureSize () {
		Picture picture =new Picture();
		picture.setId(2L);
		picture.setName("2.png");
		picture.setSourceUrl("C:\\Users\\123\\Desktop\\text\\2.png");
		picture.setDestinationUrl("D:\\yunDiskSpace\\picture\\2.png");
		picture.setSize(498274L);
		picture.setUploadTime("2020-01-06 21:25:55");
		assertEquals(picture, pictureService.findPictureByPictureSize(498274L).get(0));
	}
	@Test
	public void findPictureAmount() {
		assertEquals(1, pictureService.findPictureAmount());
		
	}
	@Test
	public void deletePictureFileByName() {
		pictureService.deletePictureFile("2.png");
		
	}
	@Test
	public void downloadPicture() {
		documentService.downloadDocument("D:\\yunDiskSpace\\picture\\2.png", "C:\\Users\\123\\Desktop\\text\\3.png");
		assertEquals(true, new File("C:\\Users\\123\\Desktop\\text\\3.png").exists());
		
	}
	@Test
	public void addOtherFile(){
		OtherFile otherFile =new OtherFile();
		otherFile.setName("2.rar");
		otherFile.setSourceUrl("C:\\Users\\123\\Desktop\\text\\2.rar");
		assertEquals(true,otherFileService.addOtherFileFile(otherFile));
		
	}
	@Test
	public void findOtherFileByName() {
		OtherFile otherFile =new OtherFile();
		otherFile.setId(1L);
		otherFile.setName("2.rar");
		otherFile.setSourceUrl("C:\\Users\\123\\Desktop\\text\\2.rar");
		otherFile.setDestinationUrl("D:\\yunDiskSpace\\otherFile\\2.rar");
		otherFile.setSize(1978L);
		otherFile.setUploadTime("2020-01-06 22:13:34");
		assertEquals(otherFile, otherFileService.findOtherFileByName("2.rar").get(0));

	}
	@Test
	public void findOtherFileByUploadTime() {
		OtherFile otherFile =new OtherFile();
		otherFile.setId(1L);
		otherFile.setName("2.rar");
		otherFile.setSourceUrl("C:\\Users\\123\\Desktop\\text\\2.rar");
		otherFile.setDestinationUrl("D:\\yunDiskSpace\\otherFile\\2.rar");
		otherFile.setSize(1978L);
		otherFile.setUploadTime("2020-01-06 22:13:34");
		assertEquals(otherFile, otherFileService.findOtherFileByUploadTime("2020-01-06 22:13:34").get(0));
		
	}
	@Test
        
	public void findOtherFileByOtherFileSize () {
		OtherFile otherFile =new OtherFile();
		otherFile.setId(1L);
		otherFile.setName("2.rar");
		otherFile.setSourceUrl("C:\\Users\\123\\Desktop\\text\\2.rar");
		otherFile.setDestinationUrl("D:\\yunDiskSpace\\otherFile\\2.rar");
		otherFile.setSize(1978L);
		otherFile.setUploadTime("2020-01-06 22:13:34");
		assertEquals(otherFile, otherFileService.findOtherFileByOtherFileSize(1978L).get(0));
	}
	@Test
	public void findOtherFileAmount() {
		assertEquals(1, otherFileService.findOtherFileAmount());
		
	}
	@Test
	public void deleteOtherFileFileByName() {
		otherFileService.deleteOtherFileFile("2.rar");
		
	}
	@Test
	public void downloadOtherFile() {
		otherFileService.downloadOtherFile("D:\\yunDiskSpace\\picture\\2.rar", "C:\\Users\\123\\Desktop\\text\\3.rar");
		assertEquals(true, new File("C:\\Users\\123\\Desktop\\text\\3.rar").exists());
		
	}
}