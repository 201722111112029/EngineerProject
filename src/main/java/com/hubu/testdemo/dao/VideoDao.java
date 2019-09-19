package com.hubu.testdemo.dao;

import com.hubu.testdemo.entity.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoDao extends JpaRepository<Video,Long>  {
}
