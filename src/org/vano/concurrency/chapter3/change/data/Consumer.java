package org.vano.concurrency.chapter3.change.data;

import java.util.List;
import java.util.concurrent.Exchanger;

/**
 * Created with IntelliJ IDEA.
 * User: Ivan_Pukhau
 * Date: 6/6/13
 * Time: 7:11 PM
 * To change this template use File | Settings | File Templates.
 */
public class Consumer implements Runnable {

    private List<String> buffer;

    private Exchanger<List<String>> exchanger;

    public Consumer(List<String> buffer, Exchanger<List<String>> exchanger) {
        this.buffer = buffer;
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        int cycle = 1;
        for(int i = 0; i < 10; i++) {
            System.out.printf("Consumer: Cycle %d\n", cycle);
            try {
                buffer = exchanger.exchange(buffer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Consumer: " + buffer.size());
            for(int j = 0; j < 10; j++) {
                String message = buffer.get(0);
                System.out.println("Consumer: " + message);
                buffer.remove(0);
            }
            cycle++;
        }
    }
}
