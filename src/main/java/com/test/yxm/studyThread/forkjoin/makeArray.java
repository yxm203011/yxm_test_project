package com.test.yxm.studyThread.forkjoin;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class makeArray {
    public static final Integer arraylength = 4000;
    public static final Integer threshold = 47;

    public static int[] makeArr(){
        Random r = new Random();
        int[] result = new int[arraylength];
        for (Integer i = 0; i < arraylength; i++) {
            result[i] = r.nextInt(arraylength * 3);
        }
        return result;
    }

    /*public static void main(String[] args) {
        int count = 0;
        int[] src = makeArr();
        long start = System.currentTimeMillis();
        for (int i = 0; i < src.length; i++) {
            count = count + src[i];
        }
        System.out.println("和为："+count+"时间为"+(System.currentTimeMillis() - start));
    }*/

    public static void main(String[] args) {
        int[] src = makeArr();
        ForkJoinPool pool = new ForkJoinPool();

    }


}
