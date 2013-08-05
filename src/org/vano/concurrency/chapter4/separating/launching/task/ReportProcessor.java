package org.vano.concurrency.chapter4.separating.launching.task;

import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * User: Ivan_Pukhau
 * Date: 8/5/13
 * Time: 11:50 AM
 * To change this template use File | Settings | File Templates.
 */
public class ReportProcessor implements Runnable {

    private CompletionService<String> service;

    private boolean end;

    public ReportProcessor(CompletionService<String> service) {
        this.service = service;
        this.end = false;
    }

    @Override
    public void run() {
        while(!end) {
            try {
                Future<String> result = service.poll(20, TimeUnit.SECONDS);
                if (result != null) {
                    String report = result.get();
                    System.out.printf("ReportRecevier: Report Recieved: %s\n", report);
                }
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
            System.out.printf("Report Sender: End\n");
        }
    }

    public void setEnd(boolean end) {
        this.end = end;
    }
}
