package com.test.yxm.service;

import com.test.yxm.mapper.projectMapper;
import com.test.yxm.model.project;
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
