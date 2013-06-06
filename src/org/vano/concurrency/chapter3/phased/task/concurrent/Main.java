package org.vano.concurrency.chapter3.phased.task.concurrent;

/**
 * Created with IntelliJ IDEA.
 * User: Ivan_Pukhau
 * Date: 6/6/13
 * Time: 6:38 PM
 * To change this template use File | Settings | File Templates.
 */
public class Main {

    private static final int STUDENTS_COUNT = 5;

    public static void main(String[] args) {
        MyPhaser phaser = new MyPhaser();
        Student[] students = new Student[STUDENTS_COUNT];
        for(int i = 0; i < students.length; i++) {
            students[i] = new Student(phaser);
            phaser.register();
        }

        Thread threads[] = new Thread[students.length];
        for(int i = 0; i < students.length; i++) {
            threads[i] = new Thread(students[i], "Student-" + i);
            threads[i].start();
        }

        for(int i = 0; i < threads.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.printf("Main: The phaser has finished: %s. \n", phaser.isTerminated());

    }
}
