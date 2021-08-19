package com.test.yxm.junit.studyThread.semaphore;

import java.sql.Connection;
import java.util.Random;

public class AppTest {
    private static UserSemaphore dbpool = new UserSemaphore();

    private static class BusiThread extends Thread {
        @Override
        public void run() {
            Random r = new Random();
            long start = System.currentTimeMillis();
            try {
                Connection connection = dbpool.taskConnect();
                System.out.println("Thread_" + Thread.currentThread().getId() + "_获取数据库共耗时【"+(System.currentTimeMillis()-start)+"】ms");
                Thread.sleep(100+r.nextInt(100));
                System.out.println("数据查询完成归还链接");
                dbpool.returnConnection(connection);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {
        for (int i = 0 ;i<50;i++){
            Thread thread = new BusiThread();
            thread.start();
        }
    }
}
