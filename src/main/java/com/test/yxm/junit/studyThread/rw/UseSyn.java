package com.test.yxm.junit.studyThread.rw;

public class UseSyn implements GoodsService{

    private GoodsInfo goodsInfo;

    public UseSyn(GoodsInfo goodsInfo){
        this.goodsInfo = goodsInfo;
    }

    @Override
    public synchronized GoodsInfo getNum() throws InterruptedException {
        Thread.sleep(5);
        return this.goodsInfo;
    }

    @Override
    public synchronized void setNum(int number) throws InterruptedException {
        Thread.sleep(5);
        goodsInfo.changeNumber(number);
    }
}
