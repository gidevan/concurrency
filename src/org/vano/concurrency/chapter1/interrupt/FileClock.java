package org.vano.concurrency.chapter1.interrupt;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * User: Ivan_Pukhau
 * Date: 4/19/13
 * Time: 10:12 AM
 * To change this template use File | Settings | File Templates.
 */
public class FileClock implements Runnable {

    private static final int COUNT = 10;

    @Override
    public void run() {
        for(int i = 0; i < COUNT; i++) {
            System.out.printf("%s\n", new Date());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                System.out.println("The FileClock has been interrupted");
            }
        }

    }
}
