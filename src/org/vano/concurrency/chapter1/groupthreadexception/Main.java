package org.vano.concurrency.chapter1.groupthreadexception;

/**
 * Created by IntelliJ IDEA.
 * User: vano
 * Date: 06.05.13
 * Time: 1:12
 * To change this template use File | Settings | File Templates.
 */
public class Main {

    public static void main(String[] args) {
        MyThreadGroup group = new MyThreadGroup("MyThreadGroup");
        Task task = new Task();
        for(int i=0; i < 2; i++) {
            Thread t = new Thread(group, task);
            t.start();
        }
    }
}
