package com.test.yxm.junit.service;

import com.test.yxm.junit.mapper.projectMapper;
import com.test.yxm.junit.model.project;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class projectService {

    @Resource
    projectMapper projectmapper;

    public project selectProject(int id){
        return projectmapper.selectProject(id);
    }
}
