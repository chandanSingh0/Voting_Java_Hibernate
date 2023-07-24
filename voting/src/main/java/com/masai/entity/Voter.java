package com.masai.entity;

import java.sql.Date;
import java.util.List;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
public class Voter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String password;
    private String address;
    private String city;
    private String state;
    
    private String postalCode;
    private String verificationStatus;
    private Date lastLoginTimestamp;

    @ManyToMany
    @JoinTable(
        name = "voter_election",
        joinColumns = @JoinColumn(name = "voter_id"),
        inverseJoinColumns = @JoinColumn(name = "election_id")
    )
    private List<Election> elections;

    // Constructors, getters, and setters
    public Voter() {
		// TODO Auto-generated constructor stub
	}

	public Voter(String name, String email, String password, String address, String city, String state,
			String postalCode, String verificationStatus, Date lastLoginTimestamp, List<Election> elections) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.address = address;
		this.city = city;
		this.state = state;
		this.postalCode = postalCode;
		this.verificationStatus = verificationStatus;
		this.lastLoginTimestamp = lastLoginTimestamp;
		this.elections = elections;
	}

	public Voter(Long id, String name, String email, String password, String address, String city, String state,
			String postalCode, String verificationStatus, Date lastLoginTimestamp, List<Election> elections) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.address = address;
		this.city = city;
		this.state = state;
		this.postalCode = postalCode;
		this.verificationStatus = verificationStatus;
		this.lastLoginTimestamp = lastLoginTimestamp;
		this.elections = elections;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getVerificationStatus() {
		return verificationStatus;
	}

	public void setVerificationStatus(String verificationStatus) {
		this.verificationStatus = verificationStatus;
	}

	public Date getLastLoginTimestamp() {
		return lastLoginTimestamp;
	}

	public void setLastLoginTimestamp(Date lastLoginTimestamp) {
		this.lastLoginTimestamp = lastLoginTimestamp;
	}

	public List<Election> getElections() {
		return elections;
	}

	public void setElections(List<Election> elections) {
		this.elections = elections;
	}

	@Override
	public String toString() {
		return "Voter [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", address="
				+ address + ", city=" + city + ", state=" + state + ", postalCode=" + postalCode
				+ ", verificationStatus=" + verificationStatus + ", lastLoginTimestamp=" + lastLoginTimestamp
				+ ", elections=" + elections + "]";
	}
    
}

