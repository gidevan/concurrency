package org.vano.concurrency.chapter2.lock.condition;

/**
 * Created with IntelliJ IDEA.
 * User: Ivan_Pukhau
 * Date: 5/21/13
 * Time: 6:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class FileMock {

    private String content[];
    private int index;

    public FileMock(int size, int length) {
        content = new String[size];
        for(int i = 0; i < size; i++) {
            StringBuilder buffer = new StringBuilder(length);
            for(int j = 0; j < length; j++) {
                int indice = (int) Math.random() * 255;
                buffer.append((char)indice);
            }
            content[i] = buffer.toString();
            index = 0;
        }
    }

    public boolean hasMoreLines() {
        return index < content.length;
    }

    public String getLine() {
        if(hasMoreLines()) {
            System.out.println("Mock: " + (content.length - index));
            return content[index++];
        }
        return null;
    }
}
