package org.vano.concurrency.chapter6.non.blocking.list;

import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * Created by vano on 08.03.2016.
 */
public class AddTask implements Runnable {
    private ConcurrentLinkedDeque<String> list;

    public AddTask(ConcurrentLinkedDeque<String> list) {
        this.list = list;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        for(int i = 0; i< 10000; i++) {
            list.add(name + ": Element " + i);
        }
    }
}
