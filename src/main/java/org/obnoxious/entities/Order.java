package org.obnoxious.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue
    private Long OrderId;

    private String packageName;

    @NotNull
    private String eventVenue;

    @NotNull
    private String eventAddress;

    @NotNull
    private String eventName;

    private String selectedService;

    @OneToOne
    @JoinColumn(name = "event_date_time")
    private EventDateTime eventDateTime;

    @OneToOne
    @JoinColumn(name = "user_id")
    private ApplicationUser userId;


    public Order() {
    }

    public Order(String packageName, String eventVenue, String eventAddress, String eventName, String selectedService, EventDateTime eventDateTime, ApplicationUser userId1) {
        this.packageName = packageName;
        this.eventVenue = eventVenue;
        this.eventAddress = eventAddress;
        this.eventName = eventName;
        this.selectedService = selectedService;
        this.eventDateTime = eventDateTime;
        this.userId = userId1;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public Long getOrderId() {
        return OrderId;
    }

    public void setOrderId(Long orderId) {
        OrderId = orderId;
    }

    public String getEventVenue() {
        return eventVenue;
    }

    public void setEventVenue(String eventVenue) {
        this.eventVenue = eventVenue;
    }

    public String getEventAddress() {
        return eventAddress;
    }

    public void setEventAddress(String eventAddress) {
        this.eventAddress = eventAddress;
    }

    public ApplicationUser getUserId() {
        return userId;
    }

    public void setUserId(ApplicationUser userId) {
        this.userId = userId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public EventDateTime getEventDateTime() {
        return eventDateTime;
    }

    public void setEventDateTime(EventDateTime eventDateTime) {
        this.eventDateTime = eventDateTime;
    }

    public String getSelectedService() {
        return selectedService;
    }

    public void setSelectedService(String selectedService) {
        this.selectedService = selectedService;
    }
}
