package edu.colostate.cs.cs414.tba.gymmanagement;

import java.util.HashSet;
import java.util.Set;

public class Customer {
	private PersonalInformation personalInformation;
	private Address address;
	private Insurance insurance;
	private Set<WorkoutRoutine> workouts = new HashSet<WorkoutRoutine>();
	
	public Customer(PersonalInformation personalInformation, Address address, Insurance insurance) {
		this.personalInformation = personalInformation;
		this.address = address;
		this.insurance = insurance;
	}
	
	public PersonalInformation getPersonalInformation() {
		return this.personalInformation;
	}
	
	@Override
	public boolean equals(Object other) {
		return this.personalInformation.getName() == ((Customer) other).getPersonalInformation().getName(); 
	}

	public Set<WorkoutRoutine> getWorkoutRoutines() {
		return this.workouts;
	}

	public void addWorkoutRoutine(WorkoutRoutine workout) {
		this.workouts.add(workout);
	}

	public Object getInsurance() {
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
