package org.vano.concurrency.chapter2.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA.
 * User: Ivan_Pukhau
 * Date: 5/17/13
 * Time: 6:57 PM
 * To change this template use File | Settings | File Templates.
 */
public class PrintQueue {

    private final Lock queueLock = new ReentrantLock();

    public void printJob(Object document) {
        queueLock.lock();
        try {
            Long duration = (long) Math.random() * 10000;
            System.out.println(Thread.currentThread().getName() + ": PrintQueue: Printing a job during "
                    + (duration/1000) + " seconds");
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            queueLock.unlock();
        }
    }
}
