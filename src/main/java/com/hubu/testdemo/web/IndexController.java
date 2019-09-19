package com.hubu.testdemo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.hubu.testdemo.entity.Student;
import com.hubu.testdemo.entity.User;
import com.hubu.testdemo.service.StudentService;

import com.hubu.testdemo.service.UserService;

@Controller
@RequestMapping("/")
public class IndexController {

    @Autowired
    private UserService userService;


    @Autowired
    private StudentService studentService;

    @RequestMapping("/")
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index");
        return mav;
    }

    @RequestMapping("/user")
    public ModelAndView user() {
        ModelAndView mav = new ModelAndView();
        User user = userService.getUser(1l);
        mav.addObject("user", user);
        mav.setViewName("user");
        return mav;
    }


    @RequestMapping("/student")
    public ModelAndView student() {
        ModelAndView mav = new ModelAndView();
        Student student = studentService.getStudent(1);
        mav.addObject("student", student);
        mav.setViewName("student");
        return mav;
    }

}