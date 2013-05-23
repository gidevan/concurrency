package org.vano.concurrency.chapter3.cyclic.barrier;

/**
 * Created with IntelliJ IDEA.
 * User: Ivan_Pukhau
 * Date: 5/23/13
 * Time: 2:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class Results {

    private int data[];

    public Results(int size) {
        data = new int[size];
    }

    public void setData(int position, int value) {
        data[position] = value;
    }

    public int[] getData() {
        return data;
    }
}
