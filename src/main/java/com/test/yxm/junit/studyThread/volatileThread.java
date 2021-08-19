package com.test.yxm.junit.studyThread;

public class volatileThread {
    private static boolean flag;
    private volatile static int number;

    private static class myThread extends Thread{
        @Override
        public void run() {
            System.out.println("进入线程方法");
            while ( number == 0 );
                System.out.println("number:"+flag);

        }
    }



    public static void main(String[] args) throws Exception{
        new myThread().start();
        Thread.sleep(1000);
        flag = true;
        number = 51;
        Thread.sleep(1000);
        System.out.println("main方法结束");
    }
}
