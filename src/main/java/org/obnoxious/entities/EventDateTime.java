package org.obnoxious.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class EventDateTime {

    @Id
    @GeneratedValue
    @Column(name = "event_dat_id")
    private Long eventDatId;
    @Column(name = "event_date", nullable = false)
    private String eventDate;
    @Column(name = "event_time", nullable = false)
    private String eventTime;
    @Column(name = "guest_count")
    private String guest_count;

    public EventDateTime() {
    }

    public EventDateTime(String eventDate, String eventTime, String guest_count) {
        this.eventDate = eventDate;
        this.eventTime = eventTime;
        this.guest_count = guest_count;
    }

    public Long getEventId() {
        return eventDatId;
    }

    public void setEventId(Long eventDatId) {
        this.eventDatId = eventDatId;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventTime() {
        return eventTime;
    }

    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }

    public String getGuest_count() {
        return guest_count;
    }

    public void setGuest_count(String guest_count) {
        this.guest_count = guest_count;
    }
}
