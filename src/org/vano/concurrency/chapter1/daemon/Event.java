package org.vano.concurrency.chapter1.daemon;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Ivan_Pukhau
 * Date: 4/22/13
 * Time: 11:27 AM
 * To change this template use File | Settings | File Templates.
 */
public class Event {

    private Date date;
    private String event;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }
}
