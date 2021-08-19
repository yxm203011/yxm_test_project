package com.test.yxm.junit.studyThread.rw;

public interface GoodsService {
    public GoodsInfo getNum() throws InterruptedException;

    public void setNum(int number) throws InterruptedException;
}
