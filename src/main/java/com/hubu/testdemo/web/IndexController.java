package com.hubu.testdemo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.hubu.testdemo.service.UserService;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class IndexController {

    @Autowired
    private UserService userService;
    //进入应用首页登录界面
    @GetMapping("/home")
    public ModelAndView getTest(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("login");
        return mav;
    }

    @PostMapping("/checkLegitimacy")
    public ModelAndView login(@RequestParam("username") String username,@RequestParam("password") String password){
       boolean flag = userService.checkLegitimacy(username,password);
       ModelAndView mav = new ModelAndView();
       mav.addObject("flag",flag);
       mav.setViewName("index");
       return mav;
    }
    @GetMapping("/toTup")
    public ModelAndView page1(){
    ModelAndView mav = new ModelAndView();
    mav.setViewName("tup");
    return mav;
    }
    @GetMapping("/toWend")
    public ModelAndView page2(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("wend");
        return mav;
    }
    @GetMapping("/toIndex")
    public ModelAndView page3(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index");
        return mav;
    }
}