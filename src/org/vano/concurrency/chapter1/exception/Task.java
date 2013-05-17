package org.vano.concurrency.chapter1.exception;

/**
 * Created with IntelliJ IDEA.
 * User: Ivan_Pukhau
 * Date: 4/22/13
 * Time: 12:10 PM
 * To change this template use File | Settings | File Templates.
 */
public class Task implements Runnable {
    @Override
    public void run() {
        int num = Integer.parseInt("rr");
    }
}
