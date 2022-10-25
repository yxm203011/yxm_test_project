package com.yxm.spring.ioc.bookshop.service;

import com.yxm.spring.ioc.bookshop.dao.BookDao;

public class BookService {

    private BookDao bookDao;

    public void purchase(){
        System.out.println("正在采购图书采购方法");
        bookDao.insert();
    }

    public BookDao getBookDao() {
        return bookDao;
    }

    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }
}
