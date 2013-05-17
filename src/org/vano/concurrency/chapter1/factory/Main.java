package org.vano.concurrency.chapter1.factory;

/**
 * Created with IntelliJ IDEA.
 * User: Ivan_Pukhau
 * Date: 5/6/13
 * Time: 4:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class Main {

    public static void main(String[] args) {
        MyThreadFactory threadFactory = new MyThreadFactory("MyTgreadFactory");
        Task task = new Task();
        Thread thread;
        System.out.println("Starting the threads");
        for(int i = 0; i < 10; i++) {
            thread = threadFactory.newThread(task);
            thread.start();
        }
        System.out.println("Factory stats:\n");
        System.out.printf(" %s \n", threadFactory.getStatistics());
    }
}
