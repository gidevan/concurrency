package org.vano.concurrency.chapter4.first;

/**
 * Created with IntelliJ IDEA.
 * User: Ivan_Pukhau
 * Date: 6/7/13
 * Time: 7:08 PM
 * To change this template use File | Settings | File Templates.
 */
public class Main {

    public static void main(String[] args) {
        Server server = new Server();
        for(int i = 0; i < 100; i++) {
            Task task = new Task("Task" + i);
            server.executeTask(task);
        }
        server.endServer();
    }
}
