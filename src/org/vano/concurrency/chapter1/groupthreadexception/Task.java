package org.vano.concurrency.chapter1.groupthreadexception;

import java.util.Random;

/**
 * Created by IntelliJ IDEA.
 * User: vano
 * Date: 06.05.13
 * Time: 0:38
 * To change this template use File | Settings | File Templates.
 */
public class Task implements Runnable {

    @Override
    public void run() {
        int result;
        Random random = new Random(Thread.currentThread().getId());
        while(true) {
            result = 1000/ (int) (random.nextDouble()*1000);
            System.out.printf("%s : %f\n", Thread.currentThread().getId(), result);
            if(Thread.currentThread().isInterrupted()) {
                System.out.printf("%d thread is interrupted\n", Thread.currentThread().getId());
                return;
            }
        }
    }
}
