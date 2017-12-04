package edu.colostate.cs.cs414.tba.domain;

import java.rmi.server.UID;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by a trainer, can be assigned to a customer
 * @param {name} name of the workout routine
 *
 */
public class WorkoutRoutine {
	private String name;
	private Set<Customer> customers = new HashSet<Customer>();
	private Set<Exercise> exercises = new HashSet<Exercise>();
	private UID id;
	
	public WorkoutRoutine(String name) {
		this.name = name;
		this.id = new UID();
	}

	public Object getName() {
		return this.name;
	}

	public Object getAssignedCustomers() {
		return this.customers;
	}
	
	@Override
	public String toString() {
		return this.name;
	}

	// a list of exercises is assigned to a workout routine
	public Object getExercises() {
		return this.exercises;
	}

	// a customer can be assigned to a workout routine
	public void assignCustomer(Customer customer) {
		this.customers.add(customer);
	}
	
	public void addExercise(Exercise exercise) {
		this.exercises.add(exercise);
	}

	public void resetExercises() {
		// Used to update the routine by re-entering exercises to list
		this.exercises = new HashSet<Exercise>();
	}

	public UID getId() {
		return id;
	}
}
