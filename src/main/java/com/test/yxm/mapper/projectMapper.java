package com.test.yxm.mapper;

import com.test.yxm.model.project;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface projectMapper {

    @Select("select * from project where id = #{id}")
    project selectProject(int id);
}
