package com.hubu.testdemo.dao;

import com.hubu.testdemo.entity.Music;
import com.hubu.testdemo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MusicDao extends JpaRepository<Music, Long>, JpaSpecificationExecutor<Student> {
}
