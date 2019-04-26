package org.obnoxious.entities;

import javax.persistence.*;

@Entity
@Table(name = "package")
public class Package {

    @Id
    @GeneratedValue
    @Column(name = "package_id")
    private Long apackageId;
    @Column(name = "package_type", nullable = false)
    private String apackageType;
    @Column (name = "package_decription", nullable = false)
    private String apackageDescription;
    @Column(name = "package_price", nullable = false)
    private String apackagePrice;
    @Column(name = "profile_path")
    private String aprofilePath;

    @JoinColumn(name = "event")
    @ManyToOne
    private Event event;

    public Package(){

    }

    public Package(Long apackageId, String apackageType, String apackageDescription, String apackagePrice, String aprofilePath, Long eventId) {
        this.apackageId = apackageId;
        this.apackageType = apackageType;
        this.apackageDescription = apackageDescription;
        this.apackagePrice = apackagePrice;
        this.aprofilePath = aprofilePath;
        this.event = new Event(eventId,"","");
    }

    public Long getPackageId() {
        return apackageId;
    }

    public void setPackageId(Long packageId) {
        this.apackageId = packageId;
    }

    public String getPackageType() {
        return apackageType;
    }

    public void setPackageType(String packageType) {
        this.apackageType = packageType;
    }

    public String getPackageDescription() {
        return apackageDescription;
    }

    public void setPackageDescription(String packageDescription) {
        this.apackageDescription = packageDescription;
    }

    public String getPackagePrice() {
        return apackagePrice;
    }

    public void setPackagePrice(String packagePrice) {
        this.apackagePrice = packagePrice;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    @Override
    public String toString() {
        return "Package{" +
                "packageId=" + apackageId +
                ", packageType='" + apackageType + '\'' +
                ", packageDescription='" + apackageDescription + '\'' +
                ", packagePrice='" + apackagePrice + '\'' +
                ", event=" + event +
                '}';
    }

    public String getProfilePath() {
        return aprofilePath;
    }

    public void setProfilePath(String profilePath) {
        this.aprofilePath = profilePath;
    }
}
