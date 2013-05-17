package org.vano.concurrency.chapter1.exception;

/**
 * Created with IntelliJ IDEA.
 * User: Ivan_Pukhau
 * Date: 4/22/13
 * Time: 12:05 PM
 * To change this template use File | Settings | File Templates.
 */
public class ExceptionHandler implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.printf("An exception has been captured\n");
        System.out.printf("Thread: %s\n", t.getId());
        System.out.printf("Exception: %s: %s\n", e.getClass().getName(), e.getMessage());
        System.out.println("Stack trace:");
        e.printStackTrace();
        System.out.printf("Thread status: %s\n", t.getState());
    }
}
