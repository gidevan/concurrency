package org.vano.concurrency.chapter4.running.multiple.tasks;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * User: Ivan_Pukhau
 * Date: 8/1/13
 * Time: 5:13 PM
 * To change this template use File | Settings | File Templates.
 */
public class Task implements Callable<Result> {

    private String name;

    public Task(String name) {
        this.name = name;
    }

    @Override
    public Result call() throws Exception {
        System.out.printf("%s is starting\n", name);
        try {
            long duration = (long) (Math.random() * 10);
            System.out.printf("%s: Waiting %d seconds for results.\n", name, duration);
            TimeUnit.SECONDS.sleep(duration);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        int value = 0;
        for(int i = 0; i < 5; i++) {
            value += (int)(Math.random() * 100);
        }
        Result result = new Result();
        result.setName(name);
        result.setValue(value);
        System.out.printf("%s: Ends\n", name);
        return result;
    }
}
