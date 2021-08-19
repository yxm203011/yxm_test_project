package com.test.yxm.junit.studyThread;

public class createThread {

    private static class myThread extends Thread{
        @Override
        public void run(){
            super.run();
            System.out.println("线程1");
        }
    }

    private static  class myRunnable implements Runnable{
        @Override
        public void run() {
            System.out.println("线程2");
        }
    }


    public static void main(String[] args) throws Exception{
        myThread mythread = new myThread();
        mythread.run();

        myRunnable myrunnnable = new myRunnable();
        new Thread(myrunnnable).start();

    }
}
