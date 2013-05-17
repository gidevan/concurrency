package org.vano.concurrency.chapter2.condition;

/**
 * Created with IntelliJ IDEA.
 * User: Ivan_Pukhau
 * Date: 5/8/13
 * Time: 6:18 PM
 * To change this template use File | Settings | File Templates.
 */
public class Consumer implements Runnable {

    private EventStorage storage;

    public Consumer(EventStorage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        for(int i = 0; i < 100; i++) {
            storage.get();
        }
    }
}
