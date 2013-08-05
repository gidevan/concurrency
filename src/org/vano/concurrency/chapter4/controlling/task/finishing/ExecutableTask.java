package org.vano.concurrency.chapter4.controlling.task.finishing;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * User: Ivan_Pukhau
 * Date: 8/5/13
 * Time: 11:04 AM
 * To change this template use File | Settings | File Templates.
 */
public class ExecutableTask implements Callable<String> {

    private String name;

    public ExecutableTask(String name) {
        this.name = name;
    }

    @Override
    public String call() throws Exception {
        try {
            long duration = (long) (Math.random() * 10);
            System.out.printf("%s: Waiting %d seconds for results.\n", name, duration);
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            System.out.println("ExecutableTask thrown an exception: name: " + name);
            e.printStackTrace();
        }
        return "Hello, world. I'm " + name;
    }

    public String getName() {
        return name;
    }
}
