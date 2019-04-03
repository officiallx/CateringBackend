package org.obnoxious.entities;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue
    private Long id;

	@Column(name = "first_name")
    private String fname;

	@Column(name = "last_name")
    private String lname;

	@Column(name = "email")
	private String email;

	@Column(name = "contact")
	private String contact;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}

	public User(String fname, String lname, String email, String contact) {
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.contact = contact;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", fname=" + fname + ", lname=" + lname + "]";
	}

	public User() {
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}
}
