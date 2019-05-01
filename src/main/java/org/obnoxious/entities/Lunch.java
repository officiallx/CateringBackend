package org.obnoxious.entities;

import javax.persistence.*;

@Entity
@Table(name = "lunch")
public class Lunch {

    @Id
    @GeneratedValue
    private Long lunchId;
    @Column(name = "lunch_name")
    private String lunchName;

    @JoinColumn(name = "packageId")
    @ManyToOne
    private Package aPackage;

    public Lunch() {
    }

    public Lunch(String lunchName, Package aPackage) {
        this.lunchName = lunchName;
        this.aPackage = aPackage;
    }

    public Long getLunchId() {
        return lunchId;
    }

    public void setLunchId(Long lunchId) {
        this.lunchId = lunchId;
    }

    public Package getaPackage() {
        return aPackage;
    }

    public void setaPackage(Package aPackage) {
        this.aPackage = aPackage;
    }

    public String getLunchName() {
        return lunchName;
    }

    public void setLunchName(String lunchName) {
        this.lunchName = lunchName;
    }
}
