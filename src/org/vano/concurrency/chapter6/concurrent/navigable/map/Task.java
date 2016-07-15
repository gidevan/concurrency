package org.vano.concurrency.chapter6.concurrent.navigable.map;

import java.util.concurrent.ConcurrentSkipListMap;

/**
 * Created by Ivan_Pukhov on 7/15/2016.
 */
public class Task implements Runnable {
    private static final int COUNT = 1000;
    private ConcurrentSkipListMap<String, Contact> map;
    private String id;

    public Task(ConcurrentSkipListMap<String, Contact> map, String id) {
        this.map = map;
        this.id = id;
    }

    @Override
    public void run() {
        for(int i = 0; i < COUNT; i++) {
            Contact contact = new Contact(id, String.valueOf(i + COUNT));
            map.put(id + contact.getPhone(), contact);
        }
    }
}
