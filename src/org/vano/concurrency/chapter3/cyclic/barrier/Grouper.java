package org.vano.concurrency.chapter3.cyclic.barrier;

/**
 * Created with IntelliJ IDEA.
 * User: Ivan_Pukhau
 * Date: 5/23/13
 * Time: 4:17 PM
 * To change this template use File | Settings | File Templates.
 */
public class Grouper implements Runnable {

    private Results results;

    public Grouper(Results results) {
        this.results = results;
    }

    @Override
    public void run() {
        int finalResults = 0;
        System.out.println("Grouper: Processing results...");
        int data[] = results.getData();
        for(int number: data) {
            finalResults += number;
        }
        System.out.printf("Grouper: Total result: %d \n", finalResults);
    }
}
