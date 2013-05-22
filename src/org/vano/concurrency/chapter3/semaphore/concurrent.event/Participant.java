package org.vano.concurrency.chapter3.semaphore.concurrent.event;

import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * User: Ivan_Pukhau
 * Date: 5/22/13
 * Time: 7:05 PM
 * To change this template use File | Settings | File Templates.
 */
public class Participant implements Runnable {

    private String name;
    private VideoConference conference;

    public Participant(VideoConference conference, String name) {
        this.conference = conference;
        this.name = name;
    }

    @Override
    public void run() {
        long duration = (long) (Math.random() * 10);
        try {
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        conference.arrive(name);
    }
}
