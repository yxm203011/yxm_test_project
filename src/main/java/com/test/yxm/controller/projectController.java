package com.test.yxm.controller;

import com.test.yxm.service.projectService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class projectController {

    @Resource
    projectService projectservice;

    @RequestMapping("show/{id}")
    public String show(@PathVariable int id){
        return projectservice.selectProject(id).toString();
    }
}
