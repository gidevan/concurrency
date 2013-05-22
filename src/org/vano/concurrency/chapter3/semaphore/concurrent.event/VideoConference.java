package org.vano.concurrency.chapter3.semaphore.concurrent.event;

import java.util.concurrent.CountDownLatch;

/**
 * Created with IntelliJ IDEA.
 * User: Ivan_Pukhau
 * Date: 5/22/13
 * Time: 6:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class VideoConference implements Runnable {

    private final CountDownLatch controller;

    public VideoConference(int number) {
        controller = new CountDownLatch(number);
    }

    public void arrive(String name) {
        System.out.printf("%s has arrived\n", name);
        controller.countDown();
        System.out.printf("VideoConference: Waiting for %d participants.\n", controller.getCount());
    }

    @Override
    public void run() {
        System.out.printf("VideoConference: Initialization: %d participants.\n", controller.getCount());
        try {
            //Use await() to wait all participants
            controller.await();
            System.out.println("VideoConference: All the participants have come");
            System.out.println("VideoConference: Lets start...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
