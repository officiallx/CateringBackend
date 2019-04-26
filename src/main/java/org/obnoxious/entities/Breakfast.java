package org.obnoxious.entities;

import javax.persistence.*;

@Entity
@Table(name = "breakfast")
public class Breakfast {

    @Id
    @GeneratedValue
    private Long breakfastId;
    @Column(name = "breakfast_name")
    private String breakfastName;

    @JoinColumn(name = "packageId")
    @ManyToOne
    private Package aPackage;

    public Breakfast() {
    }

    public Breakfast(String breakfastName) {
        this.breakfastName = breakfastName;
    }

    public Long getBreakfastId() {
        return breakfastId;
    }

    public void setBreakfastId(Long breakfastId) {
        this.breakfastId = breakfastId;
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
