package com.yxm.spring.ioc.bookshop.dao;

public class BookDaoOracleImpl implements BookDao{
    @Override
    public void insert() {
        System.out.println("Oracle添加数据");
    }
}
