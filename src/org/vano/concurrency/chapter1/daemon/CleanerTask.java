package org.vano.concurrency.chapter1.daemon;

import java.util.Date;
import java.util.Deque;

/**
 * Created with IntelliJ IDEA.
 * User: Ivan_Pukhau
 * Date: 4/22/13
 * Time: 11:32 AM
 * To change this template use File | Settings | File Templates.
 */
public class CleanerTask extends Thread {

    private static final int LIMIT = 10000;


    private Deque<Event> deque;

    public CleanerTask(Deque<Event> deque) {
        this.deque = deque;
        setDaemon(true);
    }

    @Override
    public void run() {
        while(true) {
            Date date = new Date();
            clean(date);
        }
    }

    private void clean(Date date) {
        long difference;
        boolean delete;
        if (deque.isEmpty()) {
            return;
        }
        delete = false;
        do {
            Event e = deque.getLast();
            difference = date.getTime() - e.getDate().getTime();
            if (difference > LIMIT) {
                System.out.printf("Cleaner: %s\n", e.getEvent());
                deque.removeLast();
                delete = true;
            }
        } while (difference > LIMIT);
        if(delete) {
            System.out.printf("Cleaner: Size of deque: %d \n", deque.size());
        }
    }
}
