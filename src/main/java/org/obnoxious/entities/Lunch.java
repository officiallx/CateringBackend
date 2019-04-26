package org.obnoxious.entities;

import javax.persistence.*;

@Entity
@Table(name = "lunch")
public class Lunch {

    @Id
    @GeneratedValue
    private Long lunchId;
    @Column(name = "lunch_name")
    private String breakfastName;

    @JoinColumn(name = "packageId")
    @ManyToOne
    private Package aPackage;

    public Lunch() {
    }

    public Lunch(String breakfastName, Package aPackage) {
        this.breakfastName = breakfastName;
        this.aPackage = aPackage;
    }

    public Long getLunchId() {
        return lunchId;
    }

    public void setLunchId(Long lunchId) {
        this.lunchId = lunchId;
    }

    public String getBreakfastName() {
        return breakfastName;
    }

    public void setBreakfastName(String breakfastName) {
        this.breakfastName = breakfastName;
    }

    public Package getaPackage() {
        return aPackage;
    }

    public void setaPackage(Package aPackage) {
        this.aPackage = aPackage;
    }
}
