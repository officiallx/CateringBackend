package org.obnoxious.entities;

import javax.persistence.*;

@Entity
@Table(name = "package")
public class Package {

    @Id
    @GeneratedValue
    @Column(name = "package_id")
    private Long packageId;
    @Column(name = "package_type", nullable = false)
    private String packageType;
    @Column (name = "package_decription", nullable = false)
    private String packageDescription;
    @Column(name = "package_price", nullable = false)
    private String packagePrice;
    @Column(name = "profile_path")
    private String profilePath;

    @JoinColumn(name = "event")
    @ManyToOne
    private Event event;

    public Package(){

    }

    public Package(String packageType, String packageDescription, String packagePrice, String profilePath, Event event) {
        this.packageType = packageType;
        this.packageDescription = packageDescription;
        this.packagePrice = packagePrice;
        this.profilePath = profilePath;
        this.event = event;
    }

    public Long getPackageId() {
        return packageId;
    }

    public void setPackageId(Long packageId) {
        this.packageId = packageId;
    }

    public String getPackageType() {
        return packageType;
    }

    public void setPackageType(String packageType) {
        this.packageType = packageType;
    }

    public String getPackageDescription() {
        return packageDescription;
    }

    public void setPackageDescription(String packageDescription) {
        this.packageDescription = packageDescription;
    }

    public String getPackagePrice() {
        return packagePrice;
    }

    public void setPackagePrice(String packagePrice) {
        this.packagePrice = packagePrice;
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
                "packageId=" + packageId +
                ", packageType='" + packageType + '\'' +
                ", packageDescription='" + packageDescription + '\'' +
                ", packagePrice='" + packagePrice + '\'' +
                ", event=" + event +
                '}';
    }

    public String getProfilePath() {
        return profilePath;
    }

    public void setProfilePath(String profilePath) {
        this.profilePath = profilePath;
    }
}
