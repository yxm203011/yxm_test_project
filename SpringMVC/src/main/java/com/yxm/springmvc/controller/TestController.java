package com.yxm.springmvc.controller;

import com.yxm.springmvc.entity.Form;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @Author yangxiaomeng
 * @Date 2022/12/1 13:36
 * @Version 1.0
 */
@Controller
public class TestController {

    @GetMapping("/t")
    @ResponseBody //直接向页面返回数据，不进行跳转
    public String test(){
        return "success";
    }

    /*@PostMapping("/apply")
    @ResponseBody
    public String apply(@RequestParam(value = "name",defaultValue = "ANON") String name, String course, Integer[] purpose ){
        System.out.println(name);
        System.out.println(course);
        Arrays.stream(purpose).forEach(m -> System.out.println(m));
        return "";
    }*/

    @PostMapping("/apply")
    @ResponseBody
    public String apply(Form form){
        System.out.println(form.getName());
        System.out.println(form.getCourse());
        form.getPurpose().forEach(m -> System.out.println(m));
        return "";
    }

    /*@PostMapping("/apply")
    @ResponseBody
    public String apply1(@RequestParam Map form){
        return "success";
    }*/
}
