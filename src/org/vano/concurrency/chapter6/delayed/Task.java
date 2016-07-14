package org.vano.concurrency.chapter6.delayed;

import java.util.Date;
import java.util.concurrent.DelayQueue;

/**
 * Created by Ivan_Pukhov on 7/14/2016.
 */
public class Task implements Runnable {
    private static int FACTOR = 1000;
    private static int COUNT = 100;

    private int id;
    private DelayQueue<Event> queue;

    public Task(int id, DelayQueue<Event> queue) {
        this.id = id;
        this.queue = queue;
    }

    @Override
    public void run() {
        Date now = new Date();
        Date delay = new Date();
        delay.setTime(now.getTime() + (id * FACTOR));
        System.out.printf("Thread: %s : %s\n", id, delay);
        for(int i = 0; i < COUNT; i++) {
            Event event = new Event(delay);
            queue.add(event);
        }
    }
}
