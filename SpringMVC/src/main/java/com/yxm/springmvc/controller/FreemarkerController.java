package com.yxm.springmvc.controller;

import com.yxm.springmvc.entity.user;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author yangxiaomeng
 * @Date 2022/12/1 18:13
 * @Version 1.0
 */
@Controller
@RequestMapping("/fm")
public class FreemarkerController {

    @GetMapping("/test")
    public ModelAndView showView(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/test");
        user user = new user();
        user.setUserName("lily");
        modelAndView.addObject("u",user);
        return modelAndView;
    }

}
