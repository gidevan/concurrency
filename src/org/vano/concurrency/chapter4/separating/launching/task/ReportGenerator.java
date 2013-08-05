package org.vano.concurrency.chapter4.separating.launching.task;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * User: Ivan_Pukhau
 * Date: 8/5/13
 * Time: 11:40 AM
 * To change this template use File | Settings | File Templates.
 */
public class ReportGenerator implements Callable<String> {

    private String sender;
    private String title;

    public ReportGenerator(String sender, String title) {
        this.sender = sender;
        this.title = title;
    }

    @Override
    public String call() throws Exception {
        try {
            Long duration = (long) (Math.random() * 10);
            System.out.printf("%s_%s: ReportGenerator: Generating a report during %d seconds\n", sender, title, duration);
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return sender + " : " + title;
    }
}
