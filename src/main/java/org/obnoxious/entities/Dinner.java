package org.obnoxious.entities;

import javax.persistence.*;

@Entity
@Table(name = "dinner")
public class Dinner {

    @Id
    @GeneratedValue
    private Long dinnerId;
    @Column(name = "dinner_name")
    private String dinnerName;

    @JoinColumn(name = "packageId")
    @ManyToOne
    private Package aPackage;

    public Dinner() {
    }

    public Dinner(String dinnerName, Package aPackage) {
        this.dinnerName = dinnerName;
        this.aPackage = aPackage;
    }

    public Long getDinnerId() {
        return dinnerId;
    }

    public void setDinnerId(Long dinnerId) {
        this.dinnerId = dinnerId;
    }

    public String getDinnerName() {
        return dinnerName;
    }

    public void setDinnerName(String dinnerName) {
        this.dinnerName = dinnerName;
    }

    public Package getaPackage() {
        return aPackage;
    }

    public void setaPackage(Package aPackage) {
        this.aPackage = aPackage;
    }
}
