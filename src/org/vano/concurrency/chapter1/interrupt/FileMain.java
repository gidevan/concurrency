package org.vano.concurrency.chapter1.interrupt;

import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * User: Ivan_Pukhau
 * Date: 4/19/13
 * Time: 10:19 AM
 * To change this template use File | Settings | File Templates.
 */
public class FileMain {

    public static void main(String[] args) {
        FileClock fileClock = new FileClock();
        Thread thread = new Thread(fileClock);
        thread.start();
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }
}
