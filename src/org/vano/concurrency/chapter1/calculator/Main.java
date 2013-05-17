package org.vano.concurrency.chapter1.calculator;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created with IntelliJ IDEA.
 * User: Ivan_Pukhau
 * Date: 4/17/13
 * Time: 3:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class Main {

    private static final int COUNT = 10;

    public static void main(String[] args) throws Exception {
        //simpleThread();
        initThreadInfo();
    }

    private static void simpleThread() {
        for(int i = 0; i < COUNT; i++) {
            Calculator calc = new Calculator(i);
            Thread thread = new Thread(calc);
            thread.start();
        }
    }

    private static void initThreadInfo() throws IOException {
        Thread threads[] = new Thread[10];
        Thread.State status[] = new Thread.State[10];
        for(int i = 0; i < COUNT; i++) {
            threads[i] = new Thread(new Calculator(i));
            if (i % 2 == 0) {
                threads[i].setPriority(Thread.MAX_PRIORITY);
            } else {
                threads[i].setPriority(Thread.MIN_PRIORITY);
            }
            threads[i].setName("CalculatorThread_" + i);
        }

        try(FileWriter file = new FileWriter("\\data\\log.txt"); PrintWriter pw = new PrintWriter(file)) {
            for(int i = 0; i < COUNT; i++) {
                pw.println("Main: Status of " + threads[i].getName() + " : " + threads[i].getState());
                status[i] = threads[i].getState();
            }
            for(int i = 0; i < COUNT; i++) {
                threads[i].start();
            }

            boolean finish = false;
            while(!finish) {
                for(int i = 0; i< COUNT; i++) {
                    if(threads[i].getState() != status[i]) {
                        writeThreadInfo(pw, threads[i], status[i]);
                        status[i] = threads[i].getState();
                    }
                }
                finish = true;
                for(int i = 0; i < COUNT; i++) {
                    finish = finish && (threads[i].getState() == Thread.State.TERMINATED);
                }
            }
        }


    }

    private static void writeThreadInfo(PrintWriter pw, Thread thread, Thread.State state) {
        pw.printf("Main : Id %d - %s\n", thread.getId(), thread.getName());
        pw.printf("Main : Priority %d\n", thread.getPriority());
        pw.printf("Main : Old state %s\n", state);
        pw.printf("Main : New state %s\n", thread.getState());
        pw.printf("Main : **********************************************\n");


    }
}
