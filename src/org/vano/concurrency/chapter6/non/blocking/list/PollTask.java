package org.vano.concurrency.chapter6.non.blocking.list;

import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * Created by vano on 08.03.2016.
 */
public class PollTask implements Runnable {

    private ConcurrentLinkedDeque<String> list;

    public PollTask(ConcurrentLinkedDeque<String> list) {
        this.list = list;
    }

    @Override
    public void run() {
        for(int i = 0; i < 5000; i++) {
            list.pollFirst();
            list.pollLast();
        }
    }
}
