package edu.colostate.cs.cs414.tba.gymmanagement;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class WorkoutRoutineTest {
	private WorkoutRoutine workoutRoutine;
	
	@Before public void setUp() {
		workoutRoutine = new WorkoutRoutine("Workout1");
	}
	
	@Test
	public void testGetName() {
		assertEquals("Workout1", workoutRoutine.getName());
	}
	
	@Test
	public void testGetAssignedCustomers() {
		Set<Customer> emptyCustomers = new HashSet<Customer>();
		assertEquals(true, emptyCustomers.equals(workoutRoutine.getAssignedCustomers()));
	}
	
	@Test
	public void testAssignCustomer() {
		Set<Customer> customersTest = new HashSet<Customer>();
		Customer customer = new Customer(
				new PersonalInformation("Nathan", "Kluth", "555-555-5555", "test@example.com"),
				new Address("213", "4", "Denver", "CO", "80231"),
				new Insurance("Test", new Address("1223", "42", "Denver", "CO", "80231"))
				);
		customersTest.add(customer);
		workoutRoutine.assignCustomer(customer);
		assertEquals(true, customersTest.equals(workoutRoutine.getAssignedCustomers()));
	}
	
	@Test
	public void testGetExercises() {
		Set<Exercise> emptyExercises = new HashSet<Exercise>();
		assertEquals(true, emptyExercises.equals(workoutRoutine.getExercises()));
	}
	
	@Test
	public void testSetExercises() {
		Set<Exercise> newExercises = new HashSet<Exercise>();
		Exercise exercise = new Exercise("Bench", "1 min", 4, 10);
		newExercises.add(exercise);
		workoutRoutine.addExercise(exercise);
		assertEquals(true, newExercises.equals(workoutRoutine.getExercises()));
	}
}
