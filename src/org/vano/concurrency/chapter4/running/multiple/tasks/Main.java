package org.vano.concurrency.chapter4.running.multiple.tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created with IntelliJ IDEA.
 * User: Ivan_Pukhau
 * Date: 8/1/13
 * Time: 5:20 PM
 * To change this template use File | Settings | File Templates.
 */
public class Main {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        List<Task> list = new ArrayList<>();
        for(int i = 0; i < 3; i++) {
            Task task = new Task("Task_" + i);
            list.add(task);
        }

        List<Future<Result>> resultList = null;
        try {
            resultList = executor.invokeAll(list);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executor.shutdown();

        System.out.println("Main: Printing the results");
        for(Future<Result> res : resultList) {
            try {
                Result result = res.get();
                System.out.println(result.getName() + ": " + result.getValue());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}
