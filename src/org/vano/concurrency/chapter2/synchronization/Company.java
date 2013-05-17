package org.vano.concurrency.chapter2.synchronization;

/**
 * Created with IntelliJ IDEA.
 * User: Ivan_Pukhau
 * Date: 5/8/13
 * Time: 10:56 AM
 * To change this template use File | Settings | File Templates.
 */
public class Company implements Runnable {

    private Account account;

    public Company(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        for(int i = 0; i < 100; i++) {
            account.addAmount(1000);
        }
        System.out.println("End of Company thread");
    }
}
