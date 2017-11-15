package edu.colostate.cs.cs414.tba.domain;

import java.util.HashSet;
import java.util.Set;

import edu.colostate.cs.cs414.tba.gymmanagement.Membership;
import edu.colostate.cs.cs414.tba.gymmanagement.User;

/**
 * Customers are created by managers and managed by trainers
 * @param {PersonalInformation} the customers PI
 * @param {Address} address information
 * @param {Insurance} info on the customer's health insuracne
 *
 */
public class Customer implements User {
	private PersonalInformation personalInformation;
	private Address address;
	private Insurance insurance;
	private Set<WorkoutRoutine> workouts = new HashSet<WorkoutRoutine>();
	private Membership membership;
	
	public Customer(PersonalInformation personalInformation, Address address, Insurance insurance) {
		this.personalInformation = personalInformation;
		this.address = address;
		this.insurance = insurance;
		this.membership = Membership.ACTIVE;
	}
	
	public PersonalInformation getPersonalInformation() {
		return this.personalInformation;
	}
	
	// membership status changed, defaults to active
	public void setActive(Membership membership) {
		this.membership = membership;
	}
	
	public Membership getMembership() {
		return this.membership;
	}
	
	@Override
	public boolean equals(Object other) {
		return this.personalInformation.getName().equals(((Customer) other).getPersonalInformation().getName()); 
	}

	public Set<WorkoutRoutine> getWorkoutRoutines() {
		return this.workouts;
	}

	// customers may be assigned by trainers to workout routines
	public void addWorkoutRoutine(WorkoutRoutine workout) {
		this.workouts.add(workout);
	}

	public Insurance getInsurance() {
		return this.insurance;
	}

	public Address getAddress() {
		return this.address;
	}

	public void update(PersonalInformation personalInformation,
			Address address, Insurance insurance) {
		this.personalInformation = personalInformation;
		this.address = address;
		this.insurance = insurance;
	}
}
