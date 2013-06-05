package org.vano.concurrency.chapter3.phased.task;

import java.util.concurrent.Phaser;

/**
 * Created with IntelliJ IDEA.
 * User: Ivan_Pukhau
 * Date: 6/5/13
 * Time: 5:34 PM
 * To change this template use File | Settings | File Templates.
 */
public class Main {

    public static void main(String[] args) {
        Phaser phaser = new Phaser(3);
        FileSearch system = new FileSearch("C:\\Windows", "log", phaser);
        FileSearch apps = new FileSearch("C:\\Program Files", "log", phaser);
        FileSearch documents = new FileSearch("C:\\Documents And Settings", "log", phaser);

        Thread systemThread = new Thread(system);
        systemThread.setName("SystemThread");
        systemThread.start();
        Thread appsThread = new Thread(apps);
        appsThread.setName("appsThread");
        appsThread.start();
        Thread documentsThread = new Thread(documents);
        documentsThread.setName("documentsThread");
        documentsThread.start();

        try {
            systemThread.join();
            appsThread.join();
            documentsThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Terminated: " + phaser.isTerminated());
    }
}
