package org.vano.concurrency.chapter4.cancel.task;

import java.util.concurrent.Callable;

/**
 * Created with IntelliJ IDEA.
 * User: Ivan_Pukhau
 * Date: 8/1/13
 * Time: 6:57 PM
 * To change this template use File | Settings | File Templates.
 */
public class Task1 implements Callable<String> {

    public String call() throws Exception {
        while(true) {
            System.out.println("Task: Test");
            Thread.sleep(100);
        }
    }
}
