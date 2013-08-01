package org.vano.concurrency.chapter4.thread.pool.executor.example;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * User: Ivan_Pukhau
 * Date: 8/1/13
 * Time: 6:39 PM
 * To change this template use File | Settings | File Templates.
 */
public class Main {

    private static final int COUNT = 10;

    public static void main(String[] args) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

        System.out.printf("Main: Starting at: %s\n", new Date());
        Task task  = new Task("Task");
        ScheduledFuture<?> result = executor.scheduleAtFixedRate(task, 1, 2, TimeUnit.SECONDS);

        for(int i = 0; i < COUNT; i++) {
            System.out.printf("Main: Delay: %d\n", result.getDelay(TimeUnit.MILLISECONDS));
            //Sleep the thread during 500 milliseconds
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        executor.shutdown();
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("Main: Finished at: %s\n", new Date());
    }
}
