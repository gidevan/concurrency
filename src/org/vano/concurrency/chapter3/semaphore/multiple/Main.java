package org.vano.concurrency.chapter3.semaphore.multiple;

/**
 * Created with IntelliJ IDEA.
 * User: Ivan_Pukhau
 * Date: 5/22/13
 * Time: 6:49 PM
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    private static final int THREAD_COUNT = 10;

    public static void main(String[] args) {
        PrintQueue printQueue = new PrintQueue();
        Thread thread[] = new Thread[THREAD_COUNT];
        for(int i = 0; i < THREAD_COUNT; i++) {
            thread[i] = new Thread(new Job(printQueue), "Thread" + i);
        }
        for(int i = 0; i < THREAD_COUNT; i++) {
            thread[i].start();
        }

    }
}
