package org.vano.concurrency.chapter2.lock.readwrite;

/**
 * Created with IntelliJ IDEA.
 * User: Ivan_Pukhau
 * Date: 5/18/13
 * Time: 6:34 PM
 * To change this template use File | Settings | File Templates.
 */
public class Reader implements Runnable {

    private PricesInfo pricesInfo;

    public Reader(PricesInfo pricesInfo) {
        this.pricesInfo = pricesInfo;
    }

    @Override
    public void run() {
        for(int i = 0; i < 10; i++) {
            System.out.printf("%s : Price 1: %f\n", Thread.currentThread().getName(), pricesInfo.getPrice1());
            System.out.printf("%s : Price 2: %f\n", Thread.currentThread().getName(), pricesInfo.getPrice2());
        }
    }
}
