package org.obnoxious.entities;

import javax.persistence.*;

@Entity
@Table(name = "utensil")
public class Tableware {

    @Id
    @GeneratedValue
    @Column(name = "u_id")
    private Long uId;

    @Column(name = "u_name")
    private String uName;

    @Column(name = "u_description")
    private String uDescription;

    @Column(name = "u_charge")
    private String uCharge;

    @JoinColumn(name = "available")
    @OneToOne(cascade = {CascadeType.ALL})
    private Available uAvailable;

    public Tableware(){

    }

    public Tableware(String uName, String uDescription, String uCharge, Available uAvailable) {
        this.uName = uName;
        this.uDescription = uDescription;
        this.uCharge = uCharge;
        this.uAvailable = uAvailable;
    }

    public Long getuId() {
        return uId;
    }

    public void setuId(Long uId) {
        this.uId = uId;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuDescription() {
        return uDescription;
    }

    public void setuDescription(String uDescription) {
        this.uDescription = uDescription;
    }

    public String getuCharge() {
        return uCharge;
    }

    public void setuCharge(String uCharge) {
        this.uCharge = uCharge;
    }

    public Available getuAvailable() {
        return uAvailable;
    }

    public void setuAvailable(Available uAvailable) {
        this.uAvailable = uAvailable;
    }
}
