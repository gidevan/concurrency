package org.vano.concurrency.chapter6.priority;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * Created by vano on 11.03.2016.
 */
public class Task implements Runnable {
    public static final int COUNT  = 1000;
    private int id;
    private PriorityBlockingQueue<Event> queue;

    public Task(int id, PriorityBlockingQueue<Event> queue) {
        this.id = id;
        this.queue = queue;
    }

    @Override
    public void run() {
        for(int i = 0; i < COUNT; i++) {
            Event event = new Event(id, i);
            queue.add(event);
        }
    }
}
