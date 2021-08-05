package com.test.yxm.studyThread.forkjoin;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/**
 * 有返回值的
 */
public class sumArray {

    private static class MySortTask extends RecursiveAction {
        private File path;
        public MySortTask (File path){
            this.path = path;
        }
        @Override
        protected void compute() {
            List<MySortTask> subTasks = new ArrayList<>();
            File[] files = path.listFiles();
            if(files != null){
                for (File file : files) {
                    if(file.isDirectory()){
                        subTasks.add(new MySortTask(file));
                    }else{
                        if(file.getAbsolutePath().endsWith("xls")){
                            System.out.println("文件:"+file.getAbsolutePath());
                        }
                    }
                }
                if(!subTasks.isEmpty()){
                    for(MySortTask subtask:invokeAll(subTasks)){
                        subtask.join();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        MySortTask m = new MySortTask(new File("D://bdc"));
        pool.submit(m);
        System.out.println(m.join());

    }
}
