package org.vano.concurrency.chapter4.running.task.after.delay;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * User: Ivan_Pukhau
 * Date: 8/1/13
 * Time: 6:18 PM
 * To change this template use File | Settings | File Templates.
 */
public class Main {

    private static final int COUNT = 5;

    public static void main(String[] args) {
        ScheduledThreadPoolExecutor executor = (ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool(1);
        System.out.printf("Main: Starting at: %s\n", new Date());
        for(int i =0; i < COUNT; i++) {
            Task task = new Task("Task_" + i);
            executor.schedule(task, i + 3, TimeUnit.SECONDS);
        }
        executor.shutdown();
        try {
            executor.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("Main: Ends at %s\n", new Date());
    }
}
