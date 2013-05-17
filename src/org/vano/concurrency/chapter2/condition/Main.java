package org.vano.concurrency.chapter2.condition;

/**
 * Created with IntelliJ IDEA.
 * User: Ivan_Pukhau
 * Date: 5/8/13
 * Time: 6:20 PM
 * To change this template use File | Settings | File Templates.
 */
public class Main {

    public static void main(String[] args) {
        EventStorage storage = new EventStorage();
        Producer producer = new Producer(storage);
        Consumer consumer = new Consumer(storage);
        Thread thread1 = new Thread(producer);
        Thread thread2 = new Thread(consumer);
        thread2.start();
        thread1.start();
    }
}
