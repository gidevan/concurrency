package org.vano.concurrency.chapter4.controlling.rejected.task.executor;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created with IntelliJ IDEA.
 * User: Ivan_Pukhau
 * Date: 8/15/13
 * Time: 2:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class RejectedTaskController implements RejectedExecutionHandler {

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.printf("RejectedTackController: The task %s has been rejected\n", r.toString());
        System.out.printf("RejectedTaskController: %s\n", executor.toString());
        System.out.printf("RejectedTaskController: Terminating %s\n", executor.isTerminating());
        System.out.printf("RejectedTaskController: Terminated %s\n", executor.isTerminated());
    }
}
