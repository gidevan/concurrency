package org.vano.concurrency.chapter1.factory;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadFactory;

/**
 * Created with IntelliJ IDEA.
 * User: Ivan_Pukhau
 * Date: 5/6/13
 * Time: 3:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class MyThreadFactory implements ThreadFactory {

    private int counter =0;
    private String name;
    private List<String> stats;

    public MyThreadFactory(String name) {
        this.name = name;
        counter = 0;
        stats = new ArrayList<>();
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r, name + "-Thread-" + counter);
        counter++;
        stats.add(String.format("Cretaed thread %d with name %s on %s\n", thread.getId(), thread.getName(), new Date()));
        return thread;
    }

    public String getStatistics() {
        StringBuffer buf = new StringBuffer();
        Iterator<String> it = stats.iterator();
        while(it.hasNext()) {
            buf.append(it.next()).append("\n");

        }
        return buf.toString();
    }
}
