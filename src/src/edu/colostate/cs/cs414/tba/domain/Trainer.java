package edu.colostate.cs.cs414.tba.domain;

import edu.colostate.cs.cs414.tba.application.Availability;
import edu.colostate.cs.cs414.tba.application.User;

/**
 * Created by manager, can manage customers
 * Can assign a customer to a routine and create workouts
 * @param {username} username for trainer
 * @param {password} password for logging in
 * @param {PersonalInformation} trainer's personal info
 * @param {Address} Trainer's address
 * @param {Insurance} Trainer's insurance
 *
 */
public class Trainer implements User {
	private PersonalInformation personalInformation;
	private Address address;
	private Insurance insurance;
	private Availability availability;
	private String username;
	private String password;
	
	public Trainer(String username, String password, PersonalInformation personalInformation, Address address, Insurance insurance) {
		this.personalInformation = personalInformation;
		this.address = address;
		this.insurance = insurance;
		this.username = username;
		this.password = password;
		availability = Availability.FULLTIME;
	}
	
	@Override
	public boolean equals(Object other) {
		if ((other == null) || (this == null)) {
	        return false;
	    }
		
		return this.personalInformation.getName().equals(((Trainer) other).getPersonalInformation().getName());
	}
	
	public PersonalInformation getPersonalInformation() {
		return this.personalInformation;
	}

	@Override
	public int hashCode() {
		return this.personalInformation.getName().hashCode();
	}
	
	// A trainer has availability, defaults to FULLTIME
	public void setAvailability(Availability availability) {
		this.availability = availability;
	}
	
	public Availability getAvailability() {
		return this.availability;
	}

	public Address getAddress() {
		return this.address;
	}

	public Insurance getInsurance() {
		return this.insurance;
	}

	public void update(PersonalInformation personalInformation,
			Address address, Insurance insurance) {
		this.address = address;
		this.personalInformation = personalInformation;
		this.insurance = insurance;
		
	}

	public String getUsername() {
		return this.username;
	}
	
	public String getPassword() {
		return this.password;
	}
}
