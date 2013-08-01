package org.vano.concurrency.chapter4.thread.pool.executor.example;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Ivan_Pukhau
 * Date: 8/1/13
 * Time: 6:36 PM
 * To change this template use File | Settings | File Templates.
 */
public class Task implements Runnable {

    private String name;

    public Task(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.printf("%s: Starting at : %s\n", name, new Date());
    }
}
