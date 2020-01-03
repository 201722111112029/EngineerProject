package com.hubu.testdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hubu.testdemo.dao.StudentDao;

import com.hubu.testdemo.entity.Student;

import java.util.List;

/**
 * 注意：使用Dao层的接口时，因为springboot版本为2.1.7，
 * 所以findOne(Exemple)不能传入id值，改用findById(id).get()方法，该方法为立即加载
 * 指定id值不存在时返回值为null
 * 
 * getOne(id)方法为延迟加载，在编辑测试代码的时候，
 * 需要在方法上面加上@Transactional 事物支持
 * 但是需要注意的时如果指定id值不存在会直接抛出异常
 * 在测试代码中要throw
 */
@Service
public class StudentService {

    @Autowired
    private StudentDao studentDao;

    public Student getStudent(Integer id) {
        return studentDao.findById(id).get();
    }

    public void addStudent(Student student){
        studentDao.save(student);
    }

    public void updateStudent(){
        studentDao.updateStudent("郑同学",18,"湖北省武汉市",2);
    }

    public void deleteStudent(Integer id){
        studentDao.deleteById(id);
    }

    public List<Student> findAllStudents(){
        return studentDao.findAllStudents();
    }

    public Student findByStuName(String name){
        return studentDao.findByStuName(name);
    }
}