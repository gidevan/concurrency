package org.vano.concurrency.chapter1.finalization;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * User: Ivan_Pukhau
 * Date: 4/19/13
 * Time: 10:57 AM
 * To change this template use File | Settings | File Templates.
 */
public class DataSourceLoader implements Runnable {

    @Override
    public void run() {
        System.out.printf("Beginning data source loading: %s\n", new Date());
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("DataSourceLoader. Data source loading has finished: %s\n", new Date());
    }
}
