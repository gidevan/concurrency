package org.vano.concurrency.chapter4.controlling.task.finishing;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * Created with IntelliJ IDEA.
 * User: Ivan_Pukhau
 * Date: 8/5/13
 * Time: 11:09 AM
 * To change this template use File | Settings | File Templates.
 */
public class ResultTask extends FutureTask<String> {

    private String name;

    public ResultTask(Callable<String> callable) {
        super(callable);
        this.name = ((ExecutableTask) callable).getName();
    }

    @Override
    protected void done() {
        if (isCancelled()) {
            System.out.printf("%s: Has been cancelled\n", name);
        } else {
            System.out.printf("%s: Has been finished\n", name);
        }
    }
}
