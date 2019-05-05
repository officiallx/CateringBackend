package org.obnoxious.entities;

import javax.persistence.*;

@Entity
@Table(name = "staff")
public class Staff {

    @Id
    @GeneratedValue
    private Long staffId;
    @Column(name = "staff_fname")
    private String staffFname;
    @Column(name = "staff_lname")
    private String staffLname;
    @Column(name = "staff_contact")
    private String staffContact;
    @Column(name = "staff_email")
    private String staffEmail;

    @OneToOne
    @JoinColumn(name = "address")
    private Address staffAddress;

    @OneToOne
    @JoinColumn(name = "position")
    private Position staffPosition;

    public Staff(){

    }

    public Staff(String staffFname, String staffLname, String staffContact, String staffEmail, String staffPosition) {
        this.staffFname = staffFname;
        this.staffLname = staffLname;
        this.staffContact = staffContact;
        this.staffEmail = staffEmail;
        this.staffAddress = new Address("");
        this.staffPosition = new Position("");
    }

    public String getStaffFname() {
        return staffFname;
    }

    public void setStaffFname(String staffFname) {
        this.staffFname = staffFname;
    }

    public String getStaffLname() {
        return staffLname;
    }

    public void setStaffLname(String staffLname) {
        this.staffLname = staffLname;
    }

    public String getStaffContact() {
        return staffContact;
    }

    public void setStaffContact(String staffContact) {
        this.staffContact = staffContact;
    }

    public String getStaffEmail() {
        return staffEmail;
    }

    public void setStaffEmail(String staffEmail) {
        this.staffEmail = staffEmail;
    }

    public Address getStaffAddress() {
        return staffAddress;
    }

    public void setStaffAddress(Address staffAddress) {
        this.staffAddress = staffAddress;
    }

    public Long getStaffId() {
        return staffId;
    }

    public void setStaffId(Long staffId) {
        this.staffId = staffId;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "staffId=" + staffId +
                ", staffFname='" + staffFname + '\'' +
                ", staffLname='" + staffLname + '\'' +
                ", staffContact='" + staffContact + '\'' +
                ", staffEmail='" + staffEmail + '\'' +
                ", staffAddress='" + staffAddress + '\'' +
                '}';
    }

    public Position getStaffPosition() {
        return staffPosition;
    }

    public void setStaffPosition(Position staffPosition) {
        this.staffPosition = staffPosition;
    }
}
