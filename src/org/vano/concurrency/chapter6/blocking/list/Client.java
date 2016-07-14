package org.vano.concurrency.chapter6.blocking.list;

import java.util.Date;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/**
 * Created by vano on 09.03.2016.
 */
public class Client implements Runnable {

    private LinkedBlockingDeque<String> requestList;
    private String name;

    public Client(String name, LinkedBlockingDeque<String> requestList) {
        this.name = name;
        this.requestList = requestList;
    }

    @Override
    public void run() {
        for(int i = 0; i< 3; i++) {
            for(int j = 0; j < 5 ; j++) {
                StringBuilder request = new StringBuilder();
                request.append(name).append(":").append(i).append(":").append(j);
                try {
                    requestList.put(request.toString());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.printf("Client: %s at %s.\n", request, new Date());
            }
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.printf("Client: End.\n");
    }
}
