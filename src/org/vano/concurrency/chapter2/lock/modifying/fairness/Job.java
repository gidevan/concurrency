package org.vano.concurrency.chapter2.lock.modifying.fairness;


/**
 * Created with IntelliJ IDEA.
 * User: Ivan_Pukhau
 * Date: 5/18/13
 * Time: 7:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class Job implements Runnable {

    private PrintQueue printQueue;

    public Job(PrintQueue printQueue) {
        this.printQueue = printQueue;
    }

    @Override
    public void run() {
        System.out.printf("%s: Going to print a document \n", Thread.currentThread().getName());
        printQueue.printJob(new Object());
        System.out.printf("%s: The document has been printed\n", Thread.currentThread().getName());
    }
}
