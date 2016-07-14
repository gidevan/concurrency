package org.vano.concurrency.chapter6.priority;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * Created by vano on 11.03.2016.
 */
public class Main {
    private static final int COUNT = 5;

    public static void main(String[] args) {
        PriorityBlockingQueue<Event> queue = new PriorityBlockingQueue<>();
        Thread[] taskThreads = new Thread[COUNT];
        System.out.println("Initialization threads");
        for(int i = 0; i < COUNT; i++) {
            Task task = new Task(i, queue);
            taskThreads[i] = new Thread(task);
        }

        for(int i = 0; i < COUNT; i++) {
            taskThreads[i].start();
        }
        System.out.println("Start threads");
        for(int i = 0; i < COUNT; i++) {
            try {
                taskThreads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        System.out.printf("Main: Queue Size: %d\n", queue.size());
        for(int i = 0; i < COUNT * Task.COUNT; i++) {
            Event event = queue.poll();
            System.out.printf("Thread %s: Priority %d\n", event.getThread(), event.getPriority());
        }

        System.out.printf("Main: Queue Size: %d\n", queue.size());
        System.out.printf("Main: End of the program\n");
    }
}
