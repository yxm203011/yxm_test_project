package com.test.yxm.studyThread.future;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class UseFuture {

    private static class UserCallable implements Callable<Integer> {
        private int sum;

        @Override
        public Integer call() throws Exception {
            System.out.println("callable开始计算");
            for (int i = 0; i < 5000; i++) {
                if (Thread.currentThread().isInterrupted()) {
                    return sum;
                }
                sum = sum + i;
                System.out.println("sum = " + sum);
            }
            return sum;
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        UserCallable userCallable = new UserCallable();
        FutureTask<Integer> futureTask = new FutureTask<>(userCallable);
        Random random = new Random();
        new Thread(futureTask).start();
        int i = random.nextInt(100);
        System.out.println(i);
        if (i > 50) {
            //使用.get()获取结果
            System.out.println("Get UserCallable result = " + futureTask.get());
        } else {
            System.out.println("cancel......");
            //用来提示线程该中断了就相当于interrupt
            futureTask.cancel(true);
        }
    }
}
