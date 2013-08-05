package org.vano.concurrency.chapter4.controlling.task.finishing;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * User: Ivan_Pukhau
 * Date: 8/5/13
 * Time: 11:12 AM
 * To change this template use File | Settings | File Templates.
 */
public class Main {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        ResultTask[] resultTask = new ResultTask[5];
        for(int i = 0; i< resultTask.length; i ++) {
            ExecutableTask executableTask = new ExecutableTask("executable_task_" + i);
            resultTask[i] = new ResultTask(executableTask);
            executor.submit(resultTask[i]);
        }
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for(int i = 0; i < resultTask.length; i++) {
            resultTask[i].cancel(false);
        }

        for(int i = 0; i < resultTask.length; i++) {
            try {
                if(!resultTask[i].isCancelled()) {
                    System.out.printf("%S\n", resultTask[i].get());
                }
            } catch (InterruptedException | ExecutionException e) {
                System.out.println("Task: " + i);
                e.printStackTrace();
            }
        }

        executor.shutdown();
    }
}
