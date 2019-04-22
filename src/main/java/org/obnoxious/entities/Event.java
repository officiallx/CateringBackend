package org.obnoxious.entities;

import javax.persistence.*;

@Entity
@Table(name = "event")
public class Event {

    @Id
    @GeneratedValue
    @Column(name = "event_id")
    private Long eventId;
    @Column(name = "event_name", nullable = false)
    private String eventName;
    @Column(name = "profile_path")
    private String profilePath;

    public Event(){

    }

    public Event(Long eventId, String eventName, String profilePath) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.profilePath = profilePath;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getProfilePath() {
        return profilePath;
    }

    public void setProfilePath(String profilePath) {
        this.profilePath = profilePath;
    }
}
