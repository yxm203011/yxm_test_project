package com.yxm.springmvc.controller;

import com.yxm.springmvc.entity.user;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

/**
 * @Author yangxiaomeng
 * @Date 2022/12/1 14:08
 * @Version 1.0
 */
@Controller
@RequestMapping("/um")
public class URLMappingController {

    @GetMapping("/g")
    @ResponseBody
    public String getMapping(@RequestParam("qqq") String name,@DateTimeFormat(pattern = "yyyyMMdd") Date createTime){
        return "get:" + name;
    }

    @PostMapping("/p")
    @ResponseBody
    public String postMapping(String userName,String passWord,@DateTimeFormat(pattern = "yyyy-MM-dd") Date createTime){
        return userName+":"+passWord;
    }

    @PostMapping("/p1")
    @ResponseBody
    public String postMapping1(user u){
        return u.getUserName()+":"+u.getPassWord();
    }

    @GetMapping("/view")
    public ModelAndView showView(Integer userId){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/view.jsp");
        user user = new user();
        if(userId == 1){
            user.setUserName("lily");
        }else{
            user.setUserName("zs");
        }
        modelAndView.addObject("u",user);
        return modelAndView;
    }

    @GetMapping("/view1")
    public String showView1(Integer userId, ModelMap modelMap){
        user user = new user();
        if(userId == 1){
            user.setUserName("lily");
        }else{
            user.setUserName("zs");
        }
        modelMap.addAttribute("u",user);
        return "/view.jsp";
    }
}
