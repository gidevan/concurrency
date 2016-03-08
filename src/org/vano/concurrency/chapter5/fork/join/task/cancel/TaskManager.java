package org.vano.concurrency.chapter5.fork.join.task.cancel;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinTask;

/**
 * Created by vano on 07.03.2016.
 */
public class TaskManager {
    private List<ForkJoinTask<Integer>> tasks;

    public TaskManager() {
        this.tasks = new ArrayList<>();
    }

    public void addTasks(ForkJoinTask<Integer> task) {
        tasks.add(task);
    }

    public void cancelTask(ForkJoinTask<Integer> cancelTask) {
        for(ForkJoinTask<Integer> task : tasks) {
            if(task != cancelTask) {
                task.cancel(true);
                ((SearchNumberTask)task).writeCancelMessage();
            }
        }
    }
}
