package org.vano.concurrency.chapter1.daemon;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created with IntelliJ IDEA.
 * User: Ivan_Pukhau
 * Date: 4/22/13
 * Time: 11:42 AM
 * To change this template use File | Settings | File Templates.
 */
public class Main {

    private static final int COUNT = 4;

    public static void main(String[] args) {
        Deque<Event> deque = new ArrayDeque<>();
        WriterTask writer = new WriterTask(deque);
        for(int i = 0; i < COUNT; i++) {
            Thread thread = new Thread(writer);
            thread.start();
        }

        CleanerTask cleaner = new CleanerTask(deque);
        cleaner.start();
    }
}
