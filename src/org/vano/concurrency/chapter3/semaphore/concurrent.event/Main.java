package org.vano.concurrency.chapter3.semaphore.concurrent.event;

/**
 * Created with IntelliJ IDEA.
 * User: Ivan_Pukhau
 * Date: 5/22/13
 * Time: 7:09 PM
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    private static final int COUNT = 10;

    public static void main(String[] args) {
        VideoConference conference = new VideoConference(COUNT);
        Thread threadConference = new Thread(conference);
        threadConference.start();

        for(int i =  0; i < COUNT; i++) {
            Participant p = new Participant(conference, "Participant" + i);
            Thread t = new Thread(p);
            t.start();
        }
    }
}
