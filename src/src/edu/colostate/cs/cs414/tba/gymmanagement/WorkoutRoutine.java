package edu.colostate.cs.cs414.tba.gymmanagement;

import java.util.HashSet;
import java.util.Set;

public class WorkoutRoutine {
	private String name;
	private Set<Customer> customers = new HashSet<Customer>();
	private Set<Exercise> exercises = new HashSet<Exercise>();
	
	public WorkoutRoutine(String name) {
		this.name = name;
	}

	public Object getName() {
		return this.name;
	}

	public Object getAssignedCustomers() {
		return this.customers;
	}

	public Object getExercises() {
		return this.exercises;
	}

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
}
