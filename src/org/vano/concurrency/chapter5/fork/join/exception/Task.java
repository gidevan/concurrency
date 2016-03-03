package org.vano.concurrency.chapter5.fork.join.exception;

import java.util.concurrent.RecursiveTask;
import java.util.concurrent.TimeUnit;

/**
 * Created by vano on 03.03.2016.
 */
public class Task extends RecursiveTask<Integer> {

    private int[] array;
    private int start;
    private int end;

    public Task(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        System.out.printf("Task: Start from%d to %d", start, end);
        if(end - start < 10) {
            if(3>start && 3 <end){
                throw new RuntimeException("This task thrown an exception: Task from " +start+ " to " + end);
            }
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            int mid = (end + start) / 2;
            Task task1 = new Task(array, start, mid);
            Task task2= new Task(array, mid, end);
            invokeAll(task1, task2);
        }
        System.out.printf("Task: End from %d to %d\n", start, end);
        return 0;
    }
}
