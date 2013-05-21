package org.vano.concurrency.chapter2.lock.condition;

/**
 * Created with IntelliJ IDEA.
 * User: Ivan_Pukhau
 * Date: 5/21/13
 * Time: 7:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class Main {

    private static final int CONSUMERS_COUNT = 3;

    public static void main(String[] args) {
        FileMock mock = new FileMock(100, 100);
        Buffer buffer = new Buffer(20);

        Producer producer = new Producer(mock, buffer);
        Thread threadProducer = new Thread(producer, "Producer");

        Consumer consumers[] = new Consumer[CONSUMERS_COUNT];
        Thread threadConsumers[] = new Thread[CONSUMERS_COUNT];

        for(int i = 0; i < CONSUMERS_COUNT; i++) {
            consumers[i] = new Consumer(buffer);
            threadConsumers[i] = new Thread(consumers[i], "Consumer" + i);
        }

        threadProducer.start();
        for (int i = 0;  i < CONSUMERS_COUNT; i++) {
            threadConsumers[i].start();
        }

    }
}
