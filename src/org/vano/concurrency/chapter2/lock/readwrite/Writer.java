package org.vano.concurrency.chapter2.lock.readwrite;

/**
 * Created with IntelliJ IDEA.
 * User: Ivan_Pukhau
 * Date: 5/18/13
 * Time: 6:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class Writer implements Runnable {

    private PricesInfo pricesInfo;

    public Writer(PricesInfo pricesInfo) {
        this.pricesInfo = pricesInfo;
    }

    @Override
    public void run() {
        for(int i = 0; i < 3; i++) {
            System.out.println("Writer. Attempt to modify the prices");
            pricesInfo.setPrices(Math.random() * 10, Math.random() * 8);
            System.out.println("Writer. Prices was modified");
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
