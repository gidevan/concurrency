package org.vano.concurrency.chapter5.fork.join.creating;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * User: Ivan_Pukhau
 * Date: 8/15/13
 * Time: 4:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class Main {

    private static final int SIZE = 10000;

    public static void main(String[] args) {
        ProductListGenerator generator = new ProductListGenerator();
        List<Product> products = generator.generate(SIZE);
        Task1 task = new Task1(products, 0, products.size(), 0.20);

        ForkJoinPool pool = new ForkJoinPool();
        pool.execute(task);

        do {
            System.out.printf("Main: Thread Count: %d\n", pool.getActiveThreadCount());
            System.out.printf("Main: Thread Steal: %d\n", pool.getStealCount());
            System.out.printf("Main: Parallelism: %d\n", pool.getParallelism());
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while(!task.isDone());
        pool.shutdown();

        if(task.isCompletedNormally()) {
            System.out.println("Main: The process has completed normally");
        }

        for(int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            if(product.getPrice() != 12) {
                System.out.printf("Product %s: %f\n", product.getName(), product.getPrice());
            }
        }

        System.out.println("Main: End of the program");
    }
}
