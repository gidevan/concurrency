package org.vano.concurrency.chapter5.fork.join.creating;

import java.util.List;
import java.util.concurrent.RecursiveAction;

/**
 * Created with IntelliJ IDEA.
 * User: Ivan_Pukhau
 * Date: 8/15/13
 * Time: 4:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class Task1 extends RecursiveAction {

    private static final long serialVersionUID = 1;
    private static final int E = 10;

    private List<Product> products;
    private int first;
    private int last;
    private double increment;

    public Task1(List<Product> products, int first, int last, double increment) {
        this.products = products;
        this.first = first;
        this.last = last;
        this.increment = increment;
    }

    @Override
    protected void compute() {
        if (last - first < E) {
            updatePrices();
        } else {
            int middle = (last + first) / 2;
            System.out.printf("Task: Pending task: %s\n", getQueuedTaskCount());
            Task1 t1 = new Task1(products, first, middle + 1, increment);
            Task1 t2 = new Task1(products, middle + 1, last, increment);
            invokeAll(t1, t2);
        }
    }

    private void updatePrices() {
        for(int i = first; i < last; i++) {
            Product product = products.get(i);
            product.setPrice(product.getPrice() * (1 + increment));
        }
    }
}