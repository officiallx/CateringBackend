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
    @Column(name = "staff_address")
    private String staffAddress;

    public Staff(){

    }

    public Staff(String staffFname, String staffLname, String staffContact, String staffEmail, String staffAddress) {
        this.staffFname = staffFname;
        this.staffLname = staffLname;
        this.staffContact = staffContact;
        this.staffEmail = staffEmail;
        this.staffAddress = staffAddress;
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

    public String getStaffAddress() {
        return staffAddress;
    }

    public void setStaffAddress(String staffAddress) {
        this.staffAddress = staffAddress;
    }

    public Long getStaffId() {
        return staffId;
    }

    public void setStaffId(Long staffId) {
        this.staffId = staffId;
    }
}
