package com.test.yxm;


public class test {

    public static void main(String[] args) throws Exception {
        System.out.println("Thread Start");
        Thread thread = new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(5000l);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程中的方法");
            }
        };
        thread.start();
        System.out.println("Thread End");
    }
}
