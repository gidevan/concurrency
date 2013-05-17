package org.vano.concurrency.chapter1.interrupt;

/**
 * Created with IntelliJ IDEA.
 * User: Ivan_Pukhau
 * Date: 4/17/13
 * Time: 4:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class Main {

    public static void main(String[] args) {
        Thread task = new PrimeGenerator();
        task.start();

        try {
            task.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        task.interrupt();
    }
}
