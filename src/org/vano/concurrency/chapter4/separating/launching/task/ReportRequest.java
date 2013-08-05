package org.vano.concurrency.chapter4.separating.launching.task;

import java.util.concurrent.CompletionService;

/**
 * Created with IntelliJ IDEA.
 * User: Ivan_Pukhau
 * Date: 8/5/13
 * Time: 11:46 AM
 * To change this template use File | Settings | File Templates.
 */
public class ReportRequest implements Runnable {

    private String name;

    private CompletionService<String> service;

    public ReportRequest(String name, CompletionService<String> service) {
        this.name = name;
        this.service = service;
    }

    @Override
    public void run() {
        ReportGenerator reportGenerator = new ReportGenerator(name, "Report");
        service.submit(reportGenerator);
    }
}
