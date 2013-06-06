package org.vano.concurrency.chapter3.phased.task.concurrent;

import java.util.Date;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * User: Ivan_Pukhau
 * Date: 6/6/13
 * Time: 6:25 PM
 * To change this template use File | Settings | File Templates.
 */
public class Student implements Runnable {

    private Phaser phaser;

    public Student(Phaser phaser) {
        this.phaser = phaser;
    }

    @Override
    public void run() {
        System.out.printf("%s: Has arrived to the exam. %s\n", Thread.currentThread().getName(), new Date());
        phaser.arriveAndAwaitAdvance();

        System.out.printf("%s: Is going to the first exercise. %s\n", Thread.currentThread().getName(), new Date());
        doExercise1();
        System.out.printf("%s: Has done the first exercise. %s\n", Thread.currentThread().getName(), new Date());
        phaser.arriveAndAwaitAdvance();

        System.out.printf("%s: Is going to the second exercise. %s\n", Thread.currentThread().getName(), new Date());
        doExercise2();
        System.out.printf("%s: Has done the second exercise. %s\n", Thread.currentThread().getName(), new Date());
        phaser.arriveAndAwaitAdvance();

        System.out.printf("%s: Is going to the third exercise. %s\n", Thread.currentThread().getName(), new Date());
        doExercise3();
        System.out.printf("%s: Has done the exam. %s\n", Thread.currentThread().getName(), new Date());
        phaser.arriveAndAwaitAdvance();
    }

    private void doExercise1() {
        doTask();
    }

    private void doExercise2() {
        doTask();
    }

    private void doExercise3() {
        doTask();
    }

    private void doTask() {
        try {
            long duration = (long) (Math.random() * 10);
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
