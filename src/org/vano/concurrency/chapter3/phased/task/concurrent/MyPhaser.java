package org.vano.concurrency.chapter3.phased.task.concurrent;

import java.util.concurrent.Phaser;

/**
 * Created with IntelliJ IDEA.
 * User: Ivan_Pukhau
 * Date: 6/6/13
 * Time: 6:15 PM
 * To change this template use File | Settings | File Templates.
 */
public class MyPhaser extends Phaser {

    @Override
    protected boolean onAdvance(int phase, int registeredParties) {
        switch (phase) {
            case 0:
                return studentsArrived();
            case 1:
                return finishFirstExercise();
            case 2:
                return finishSecondExercise();
            case 3:
                return finishExam();
            default: return true;

        }
    }

    private boolean studentsArrived() {
        System.out.printf("Phaser: The exam are going to start. The students are ready. \n");
        System.out.printf("Phaser: We have %d students.\n", getRegisteredParties());
        return false;
    }

    private boolean finishFirstExercise() {
        System.out.println("Phaser: All students have finished the first exercise");
        System.out.println("Phaser: It is time for the second one");
        return false;
    }

    private boolean finishSecondExercise() {
        System.out.println("Phaser: All students have finished the second exercise");
        System.out.println("Phaser: It is time for the third one");
        return false;
    }

    private boolean finishExam() {
        System.out.println("Phaser: All students have finished the exam");
        System.out.println("Phaser: Thank you for your time");
        return false;
    }
}
