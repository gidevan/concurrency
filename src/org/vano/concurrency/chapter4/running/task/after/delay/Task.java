package org.vano.concurrency.chapter4.running.task.after.delay;

import java.util.Date;
import java.util.concurrent.Callable;

/**
 * Created with IntelliJ IDEA.
 * User: Ivan_Pukhau
 * Date: 8/1/13
 * Time: 6:15 PM
 * To change this template use File | Settings | File Templates.
 */
public class Task implements Callable<String> {

    private String name;

    public Task(String name) {
        this.name = name;
    }

    @Override
    public String call() throws Exception {
        System.out.printf("%s: Starting at %s\n", name, new Date());
        return "Hello world";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
