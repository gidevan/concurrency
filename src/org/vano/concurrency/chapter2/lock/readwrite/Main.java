package org.vano.concurrency.chapter2.lock.readwrite;

/**
 * Created with IntelliJ IDEA.
 * User: Ivan_Pukhau
 * Date: 5/18/13
 * Time: 6:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class Main {

    private static final int READER_COUNT = 5;
    private static final int WRITER_COUNT = 5;


    public static void main(String[] args) {
        PricesInfo pricesInfo = new PricesInfo();

        Reader readers[] = new Reader[READER_COUNT];
        Thread threadReaders[] = new Thread[READER_COUNT];
        for(int i =0; i < READER_COUNT; i++) {
            readers[i] = new Reader(pricesInfo);
            threadReaders[i] = new Thread(readers[i]);
        }

        Writer writer = new Writer(pricesInfo);
        Thread threadWriter = new Thread(writer);
        for(int i = 0; i < READER_COUNT; i++) {
            threadReaders[i].start();
        }
        threadWriter.start();
    }
}
