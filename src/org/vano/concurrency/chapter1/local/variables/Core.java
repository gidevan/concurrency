package org.vano.concurrency.chapter1.local.variables;

import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * User: Ivan_Pukhau
 * Date: 4/22/13
 * Time: 6:20 PM
 * To change this template use File | Settings | File Templates.
 */
public class Core {
    private static final int COUNT = 10;
    public static void main(String[] args) {
        //UnsafeTask task = new UnsafeTask();
        SafeTask task = new SafeTask();
        for(int i = 0; i < COUNT; i++) {
            Thread thread = new Thread(task);
            thread.start();
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
