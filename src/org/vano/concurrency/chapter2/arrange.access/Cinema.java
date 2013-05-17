package org.vano.concurrency.chapter2.arrange.access;

/**
 * Created with IntelliJ IDEA.
 * User: Ivan_Pukhau
 * Date: 5/8/13
 * Time: 11:21 AM
 * To change this template use File | Settings | File Templates.
 */
public class Cinema {

    private long vacancanciesCinema1;
    private long vacancanciesCinema2;

    private final Object controlCinema1;
    private final Object controlCinema2;

    public Cinema() {
        controlCinema1 = new Object();
        controlCinema2 = new Object();
        vacancanciesCinema1 = 20;
        vacancanciesCinema2 = 20;
    }

    public boolean sellTickets1(int number) {
        synchronized (controlCinema1) {
            if(number < vacancanciesCinema1) {
                vacancanciesCinema1 -= number;
                return true;
            } else {
                return false;
            }
        }
    }

    public boolean sellTickets2(int number) {
        synchronized (controlCinema2) {
            if(number < vacancanciesCinema2) {
                vacancanciesCinema2 -= number;
                return true;
            } else {
                return false;
            }
        }
    }

    public boolean returnTickets1(int number) {
        synchronized (controlCinema1) {
            vacancanciesCinema1 += number;
            return true;
        }
    }

    public boolean returnTickets2(int number) {
        synchronized (controlCinema2) {
            vacancanciesCinema2 += number;
            return true;
        }
    }

    public long getVacancanciesCinema1() {
        return vacancanciesCinema1;
    }

    public long getVacancanciesCinema2() {
        return vacancanciesCinema2;
    }
}
