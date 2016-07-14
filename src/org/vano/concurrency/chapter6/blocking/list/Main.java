package org.vano.concurrency.chapter6.blocking.list;

import java.util.Date;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/**
 * Created by vano on 09.03.2016.
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        LinkedBlockingDeque<String> list = new LinkedBlockingDeque<>();
        Client client =new Client("client1", list);
        Thread thread = new Thread(client);
        thread.start();

        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 3; j++) {

                String request = list.take();
                System.out.printf("Main: Request: %s at %s. Size:%d\n", request, new Date(), list.size());
            }
            TimeUnit.MILLISECONDS.sleep(300);
        }

        System.out.printf("Main: End of the program.\n");
    }
}
