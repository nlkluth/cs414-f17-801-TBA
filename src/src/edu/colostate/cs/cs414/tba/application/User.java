package edu.colostate.cs.cs414.tba.application;

import java.rmi.server.UID;

import edu.colostate.cs.cs414.tba.domain.Address;
import edu.colostate.cs.cs414.tba.domain.Insurance;
import edu.colostate.cs.cs414.tba.domain.PersonalInformation;

/*
 * extended by Trainer, Manager, Customer 
 * @param {username} username for user
 * @param {password} password for logging in
 * set {PersonalInformation} user personal info
 * set {Address} user address
 * set {Insurance} user insurance
 *
 */
public abstract class User {
	private PersonalInformation personalInformation;
	private UID id;
	private Address address;
	private Insurance insurance;
	private String username;
	private String password;
	
	public User(String username, String password) {
		this.username = username;
		this.password = password;
		this.id = new UID();
	}
	
	public void setPersonalInformation(PersonalInformation personalInformation) {
		this.personalInformation = personalInformation;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public String getPassword() {
		return this.password;
	}

	public PersonalInformation getPersonalInformation() {
		return this.personalInformation;
	}
	
	public UID getId() {
		return this.id;
	}
	
	public Address getAddress() {
		return this.address;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public Insurance getInsurance() {
		return this.insurance;
	}
	
	public void setInsurance(Insurance insurance) {
		this.insurance = insurance;
	}
	
	@Override
	public String toString() {
		return this.username + " " + this.personalInformation.getName();
	}
	
	@Override
	public boolean equals(Object other) {
		if ((other == null) || (this == null)) {
	        return false;
	    }
		
		return this.username.equals(((User) other).getUsername());
	}

	@Override
	public int hashCode() {
		return this.username.hashCode();
	}
	
}