package org.vano.concurrency.chapter1.finalization;

/**
 * Created with IntelliJ IDEA.
 * User: Ivan_Pukhau
 * Date: 4/19/13
 * Time: 11:02 AM
 * To change this template use File | Settings | File Templates.
 */
public class Main {

    public static void main(String[] args) {
        DataSourceLoader dsLoader = new DataSourceLoader();
        Thread thread1 = new Thread(dsLoader, "DataSourceThread");

        NetworkConnectionsLoader ncLoader = new NetworkConnectionsLoader();
        Thread thread2 = new Thread(ncLoader, "NetworkLoader");

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            System.out.println("Thread1");
            thread2.join();
            System.out.println("Thread2");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Config loaded");

    }
}
