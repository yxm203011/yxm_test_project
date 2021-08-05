package com.test.yxm.studyThread.rw;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class UseRwLock  implements GoodsService{
    private GoodsInfo goodsIInfo;

    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock getLock = lock.readLock();
    private final Lock setLock = lock.writeLock();

    public UseRwLock(GoodsInfo goodsInfo) {
        this.goodsIInfo = goodsInfo;
    }

    @Override
    public GoodsInfo getNum() throws InterruptedException {
        getLock.lock();
        try{
            Thread.sleep(5);
            return this.goodsIInfo;
        }finally {
            getLock.unlock();
        }
    }

    @Override
    public void setNum(int number) throws InterruptedException {
        setLock.lock();
        try{
            Thread.sleep(5);
            goodsIInfo.changeNumber(number);
        }finally {
            setLock.unlock();
        }
    }
}
