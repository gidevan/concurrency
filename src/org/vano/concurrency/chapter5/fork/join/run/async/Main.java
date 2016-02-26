package org.vano.concurrency.chapter5.fork.join.run.async;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

/**
 * Created by Ivan_Pukhov on 2/26/2016.
 */
public class Main {

    public static void main(String args) {
        ForkJoinPool pool = new ForkJoinPool();
        FolderProcessor system = new FolderProcessor("c:\\Windows", "log");
        FolderProcessor apps = new FolderProcessor("c:\\Program Files", "log");
        FolderProcessor documents = new FolderProcessor("c:\\Documents And Settings", "log");
        pool.execute(system);
        pool.execute(apps);
        pool.execute(documents);

        do {
            System.out.println("***************************************************");
            System.out.printf("Main: Parallelism: %d \n", pool.getParallelism());
            System.out.printf("Main: Active Threads: %d \n", pool.getActiveThreadCount());
            System.out.printf("Main: Steal Count: %d \n", pool.getStealCount());
            System.out.println("***************************************************");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (!system.isDone() || !apps.isDone() || !documents.isDone());
        pool.shutdown();
        List<String> results = system.join();
        System.out.printf("System: %d files found. \n", results.size());

        results = apps.join();
        System.out.printf("Apps: %d files found. \n", results.size());

        results = documents.join();
        System.out.printf("Documents: %d files found. \n", results.size());

    }
}
