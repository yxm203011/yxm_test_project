package com.test.yxm.junit.studyThread;

public class biubiumain {

    private static  biubiubiu bia = new biubiubiu(0,"张三");

    private static class mythread extends Thread{
        @Override
        public void run() {
            try {
                bia.addzd();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    private static class mythread1 extends Thread{
        @Override
        public void run() {
            try {
                bia.subzd();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        bia.zd();
        new mythread().start();
        Thread.sleep(1000);
        new mythread1().start();
        bia.dazidan();
        Thread.sleep(1000);

    }

}
