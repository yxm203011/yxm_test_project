package com.yxm.springmvc.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Author yangxiaomeng
 * @Date 2022/12/1 14:52
 * @Version 1.0
 */
public class user {
    private String userName;

    private Long passWord;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createTime;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getPassWord() {
        return passWord;
    }

    public void setPassWord(Long passWord) {
        this.passWord = passWord;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
