package org.vano.concurrency.chapter4.callable.tasks;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * User: Ivan_Pukhau
 * Date: 6/12/13
 * Time: 6:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class FactorialCalculator implements Callable<Integer> {

    private Integer number;

    public FactorialCalculator(Integer number) {
        this.number = number;
    }

    @Override
    public Integer call() throws Exception {
        int result = 1;
        if(number == 0 || number == 1) {
            result = 1;
        } else {
            for(int i = 2; i <= number; i++) {
                result *= i;
                TimeUnit.MILLISECONDS.sleep(1020);
            }
        }
        System.out.printf("%s: %d\n", Thread.currentThread().getName(), result);
        return result;
    }
}
