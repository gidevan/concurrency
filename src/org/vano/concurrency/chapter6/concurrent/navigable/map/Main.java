package org.vano.concurrency.chapter6.concurrent.navigable.map;

import java.util.Map;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * Created by Ivan_Pukhov on 7/15/2016.
 */
public class Main {

    private static final int THREAD_COUNT = 25;

    public static void main(String[] args) {
        ConcurrentSkipListMap<String, Contact> map = new ConcurrentSkipListMap<>();

        Thread threads[] = new Thread[THREAD_COUNT];
        int counter = 0;
        for(char i = 'A'; i < 'Z'; i++) {
            Task task = new Task(map, String.valueOf(i));
            threads[counter] = new Thread(task);
            threads[counter].start();
            counter++;
        }

        for(int i = 0; i < THREAD_COUNT; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.printf("Main: Size of the map: %d\n", map.size());
        Map.Entry<String, Contact> element = map.firstEntry();
        Contact contact = element.getValue();
        System.out.printf("Main: First Entry: %s : %s\n", contact.getName(), contact.getPhone());

        System.out.printf("Main: Submap from A1996 to B1002: \n");

        ConcurrentNavigableMap<String, Contact> submap = map.subMap("A1996", "B1002");
        do {
            element = submap.pollFirstEntry();
            if(element != null) {
                contact = element.getValue();
                System.out.printf("%s: %s\n", contact.getName(), contact.getPhone());
            }
        } while (element != null);
    }
}
