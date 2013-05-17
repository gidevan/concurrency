package org.vano.concurrency.chapter2.arrange.access;

/**
 * Created with IntelliJ IDEA.
 * User: Ivan_Pukhau
 * Date: 5/8/13
 * Time: 12:40 PM
 * To change this template use File | Settings | File Templates.
 */
public class Main {

    public static void main(String[] args) {
        Cinema cinema = new Cinema();
        TicketOffice1 ticketOffice1 = new TicketOffice1(cinema);
        TicketOffice2 ticketOffice2 = new TicketOffice2(cinema);
        Thread thread1 = new Thread(ticketOffice1, "TicketOffice1");
        Thread thread2 = new Thread(ticketOffice2, "TicketOffice2");
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Room 1 Vacancies: %d\n", cinema.getVacancanciesCinema1());
        System.out.printf("Room 2 Vacancies: %d\n", cinema.getVacancanciesCinema2());

    }
}
