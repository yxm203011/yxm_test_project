package com.test.yxm.studyThread;

public class threadLocal {
    private static ThreadLocal<Integer> integerThreadLocal = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return 1;
        }
    };

    private static ThreadLocal<String> stringThreadLocal = new ThreadLocal<String>(){
        @Override
        protected String initialValue() {
            return "a";
        }
    };


    private static class myThread extends Thread{
        private int i;
        public myThread(int i ){
            this.i = i;
        }
        @Override
        public void run() {
            Integer integer = integerThreadLocal.get();
            integer = integer + i;
            integerThreadLocal.set(integer);
            String s = stringThreadLocal.get();
            s = s + i ;
            stringThreadLocal.set(s);
            System.out.println("第一次"+Thread.currentThread().getName()+integerThreadLocal.get());
            System.out.println(Thread.currentThread().getName()+stringThreadLocal.get());
        }
    }

    private static void runThread(){
        Thread[] runs = new Thread[3];
        for (int i = 0; i < runs.length; i++) {
            runs[i] = new myThread(i);
        }
        for (int i = 0; i < runs.length; i++) {
            runs[i].start();
        }
    }

    public static void main(String[] args) {
        runThread();
    }

}
