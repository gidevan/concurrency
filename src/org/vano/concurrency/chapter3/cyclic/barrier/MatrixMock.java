package org.vano.concurrency.chapter3.cyclic.barrier;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: Ivan_Pukhau
 * Date: 5/23/13
 * Time: 2:43 PM
 * To change this template use File | Settings | File Templates.
 */
public class MatrixMock {

    private int data[][];

    public MatrixMock(int size, int length, int number) {
        int counter = 0;
        data = new int[size][length];
        Random random = new Random();
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < length; j++) {
                data[i][j] = random.nextInt(10);
                if(data[i][j] == number) {
                    counter++;
                }
            }
        }
        System.out.printf("Mock: There are %d occurences of number [%d] in generated data.\n", counter, number);
    }

    public int[] getRow(int row) {
        if((row >=0) && (row < data.length)) {
            return data[row];
        }
        return null;
    }
}
