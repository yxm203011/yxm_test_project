package com.test.yxm.studyThread;

public class endThread {

    private static class myRunnablet extends Thread {

        @Override
        public void run() {
            String name = Thread.currentThread().getName();
            System.out.println(name + "开始状态：" + isInterrupted());
            //while(!isInterrupted()){
            System.out.println(name + "前：" + isInterrupted());
            while (!Thread.interrupted()) {
                System.out.println(name + "运行中状态：" + isInterrupted());
            }
            System.out.println(name + "运行结束状态：" + Thread.interrupted());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread m = new myRunnablet();
        m.start();
        Thread.sleep(20);
        m.interrupt();
    }
}
