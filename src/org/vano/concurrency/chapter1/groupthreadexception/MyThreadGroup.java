package org.vano.concurrency.chapter1.groupthreadexception;

/**
 * Created by IntelliJ IDEA.
 * User: vano
 * Date: 06.05.13
 * Time: 0:23
 * To change this template use File | Settings | File Templates.
 */
public class MyThreadGroup extends ThreadGroup {
    public MyThreadGroup(String name) {
        super(name);
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.printf("The thread %s has thrown an exception\n", t.getId());
        e.printStackTrace();
        System.out.printf("Terminating the rest of the Thread\n");
        interrupt();
    }
}
