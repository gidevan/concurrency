package org.vano.concurrency.chapter4.cancel.task;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * User: Ivan_Pukhau
 * Date: 8/1/13
 * Time: 6:59 PM
 * To change this template use File | Settings | File Templates.
 */
public class Main {

    public static void main(String[] args) {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        Task task = new Task();

        System.out.println("Main: Executing the task");
        Future<String> result = executor.submit(task);

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Cancelling the task");
        result.cancel(true);
        System.out.printf("Main: Canceled: %s\n", result.isCancelled());
        System.out.printf("Main: Done: %s\n", result.isDone());
    }
}
