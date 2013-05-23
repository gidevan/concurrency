package org.vano.concurrency.chapter3.cyclic.barrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created with IntelliJ IDEA.
 * User: Ivan_Pukhau
 * Date: 5/23/13
 * Time: 2:59 PM
 * To change this template use File | Settings | File Templates.
 */
public class Searcher implements Runnable {

    private int firstRow;
    private int lastRow;

    private MatrixMock mock;
    private Results results;
    private int number;

    private final CyclicBarrier barrier;

    public Searcher(int lastRow, int firstRow,  MatrixMock mock, Results results, int number, CyclicBarrier barrier) {
        this.barrier = barrier;
        this.number = number;
        this.results = results;
        this.mock = mock;
        this.lastRow = lastRow;
        this.firstRow = firstRow;
    }

    @Override
    public void run() {
        int counter;
        System.out.printf("%s: Processing lines from %d to %d.\n", Thread.currentThread().getName(), firstRow, lastRow);
        for(int i = firstRow; i < lastRow; i++) {
            int row[] = mock.getRow(i);
            counter = 0;
            for(int j = 0; j < row.length; j++) {
                if(row[j] == number) {
                    counter++;
                }
            }
            results.setData(i, counter);
        }
        System.out.printf("%s: Lines processed. \n", Thread.currentThread().getName());
        try {
            barrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
