package org.vano.concurrency.chapter6.delayed;

import java.util.Date;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by Ivan_Pukhov on 7/14/2016.
 */
public class Main {

    private static final int COUNT = 5;

    public static void main(String[] args) throws InterruptedException {
        DelayQueue<Event> queue = new DelayQueue<>();
        Thread threads[] = new Thread[COUNT];
        System.out.println("Initialization");
        for(int i = 0; i < threads.length; i++) {
            Task task = new Task(i + 1, queue);
            threads[i] = new Thread(task);
        }
        System.out.println("Start threads:");
        for(int i = 0; i < threads.length; i++) {
            threads[i].start();
        }
        System.out.println("Wait for finalization of the threads:");
        for(int i = 0; i < threads.length; i++) {
            threads[i].join();
        }

        do {
            int counter = 0;
            Event event = null;
            do {
                event = queue.poll();
                if (event != null) {
                    counter++;
                }
            } while (event != null);
            System.out.printf("At %s you have read %d events\n", new Date(), counter);
            TimeUnit.MILLISECONDS.sleep(500);
        } while (queue.size() > 0);
    }
}
