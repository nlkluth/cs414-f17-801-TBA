package edu.colostate.cs.cs414.tba.domain;

import java.util.HashSet;
import java.util.Set;

import edu.colostate.cs.cs414.tba.application.Availability;
import edu.colostate.cs.cs414.tba.application.User;

/**
 * Created by manager, can manage customers
 * Can assign a customer to a routine and create workouts
 * Has availability
 */
public class Trainer extends User {
	private Availability availability;
	private Set<Qualification> qualifications = new HashSet<Qualification>();
	
	public Trainer(String username, String password) {
		super(username, password);	
		this.availability = Availability.FULLTIME;
	}
	
	public void setAvailability(Availability availability) {
		// A trainer has availability, defaults to FULLTIME
		this.availability = availability;
	}
	
	public Availability getAvailability() {
		return this.availability;
	}
	
	public void addQualification(Qualification qualification) {
		this.qualifications.add(qualification);
	}
	
	public Set<Qualification> getQualifications() {
		return this.qualifications;
	}
}
