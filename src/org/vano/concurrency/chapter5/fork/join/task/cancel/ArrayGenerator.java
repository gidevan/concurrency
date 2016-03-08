package org.vano.concurrency.chapter5.fork.join.task.cancel;

import java.util.Random;

/**
 * Created by vano on 07.03.2016.
 */
public class ArrayGenerator {

    public int[] generateArray(int size) {
        int[] array = new int[size];
        Random random = new Random();
        for(int i = 0; i < size; i++) {
            array[i] = random.nextInt();
        }
        return array;
    }
}
