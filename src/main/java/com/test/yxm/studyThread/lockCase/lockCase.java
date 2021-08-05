package com.test.yxm.studyThread.lockCase;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class lockCase {
    private Lock lock = new ReentrantLock();

    private int age = 100000;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private static class TestThread extends Thread{
        private lockCase lockCase;

        public TestThread(lockCase lockCase,String name){
            super(name);
            this.lockCase = lockCase;
        }

        @Override
        public void run() {
            for (int i = 0; i < 100000; i++) {
                lockCase.test();
            }
            System.out.println(Thread.currentThread().getName()+" age ="+lockCase.getAge());
        }
    }
    public void test(){
        lock.lock();
        try{
            age ++;
        }finally {
            lock.unlock();
        }
    }

    public void test2(){
        lock.lock();
        try{
            age --;
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        lockCase lockCase = new lockCase();
        Thread endThread = new TestThread(lockCase,"endThread");
        endThread.start();
        for (int i = 0;i<100000;i++){
            lockCase.test2();
        }
        System.out.println(Thread.currentThread().getName()+" age="+lockCase.getAge());
    }

}
