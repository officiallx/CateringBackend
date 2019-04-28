package org.obnoxious.entities;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue
    private Long OrderId;

    /*@OneToMany(cascade = CascadeType.ALL)
    @Valid
    private List<Package> packages = new ArrayList<>();*/

    private String packageName;

    private String eventVenue;

    private String eventAddress;

   /* @JoinColumn
    @OneToOne(cascade = CascadeType.ALL)
    private Package aPackage;*/

    public Order() {
    }

    public Order(String packageName, String eventVenue, String eventAddress) {
        this.packageName = packageName;
        this.eventVenue = eventVenue;
        this.eventAddress = eventAddress;
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

}
