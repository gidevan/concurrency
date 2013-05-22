package org.vano.concurrency.chapter3.semaphore.multiple;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA.
 * User: Ivan_Pukhau
 * Date: 5/22/13
 * Time: 6:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class PrintQueue {
    private static final int COUNT = 3;
    private boolean freePrinters[];
    private Semaphore semaphore;

    private Lock lockPrinters;

    public PrintQueue() {
        semaphore = new Semaphore(COUNT);
        freePrinters = new boolean[COUNT];
        for(int i = 0; i < COUNT; i++) {
            freePrinters[i] = true;
        }
        lockPrinters = new ReentrantLock();
    }

    public void printJob(Object document) {
        try {
            semaphore.acquire();
            int assignedPrinter = getPrinter();
            long duration = (long)(Math.random() * 10);
            System.out.printf("%s: PrintQueue: Printing a Job in Printer %d during %d seconds\n",
                    Thread.currentThread().getName(), assignedPrinter, duration);
            TimeUnit.SECONDS.sleep(duration);
            freePrinters[assignedPrinter] = true;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }

    private int getPrinter() {
        int ret = -1;
        try {
            lockPrinters.lock();
            for(int i = 0; i < freePrinters.length; i++) {
                if(freePrinters[i]) {
                    ret = i;
                    freePrinters[i] = false;
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lockPrinters.unlock();
        }
        return ret;
    }
}
