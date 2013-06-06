package org.vano.concurrency.chapter3.change.data;

import java.util.List;
import java.util.concurrent.Exchanger;

/**
 * Created with IntelliJ IDEA.
 * User: Ivan_Pukhau
 * Date: 6/6/13
 * Time: 6:57 PM
 * To change this template use File | Settings | File Templates.
 */
public class Producer implements Runnable {

    private List<String> buffer;

    private final Exchanger<List<String>> exchanger;

    public Producer(List<String> buffer, Exchanger<List<String>> exchanger) {
        this.exchanger = exchanger;
        this.buffer = buffer;
    }

    @Override
    public void run() {
        int cycle = 1;
        for(int i = 0; i < 10; i++) {
            System.out.printf("Producer: Cycle %d\n", cycle);
            for(int j = 0; j < 10; j++) {
                String message = "Event " + ((i * 10) + j);
                System.out.printf("Producer: %s\n", message);
                buffer.add(message);
            }
            try {
                buffer = exchanger.exchange(buffer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Producer: " + buffer.size());
            cycle++;
        }

    }
}
