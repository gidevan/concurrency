package org.vano.concurrency.chapter5.fork.join.p2.joining.result;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.RecursiveTask;

/**
 * Created with IntelliJ IDEA.
 * User: Ivan_Pukhau
 * Date: 8/16/13
 * Time: 12:08 PM
 * To change this template use File | Settings | File Templates.
 */
public class LineTask extends RecursiveTask<Integer> {

    private static final long serialVersionUID = 1l;
    private static final Integer SIZE = 100;

    private String line[];
    private int start;
    private int end;
    private String word;

    public LineTask(String[] line, int start, int end, String word) {
        this.line = line;
        this.start = start;
        this.end = end;
        this.word = word;
    }

    @Override
    protected Integer compute() {
        Integer result = null;
        if (end - start < SIZE) {
            result = count(line, start, end, word);
        } else {
            int mid = (start + end) / 2;
            LineTask task1 = new LineTask(line, start, mid, word);
            LineTask task2 = new LineTask(line, mid, end, word);
            invokeAll(task1, task2);
            try {
                result = groupResult(task1.get(), task2.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    private Integer count(String[] line, int start, int end, String word) {
        int counter = 0;
        for(int i = start; i < end; i++) {
            if (line[i].equals(word)) {
                counter++;
            }
        }
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return counter;
    }

    private Integer groupResult(Integer number1, Integer number2) {
        return number1 + number2;
    }
}
