package edu.colostate.cs.cs414.tba.tests;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.rmi.server.UID;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import edu.colostate.cs.cs414.tba.domain.Address;
import edu.colostate.cs.cs414.tba.domain.Customer;
import edu.colostate.cs.cs414.tba.domain.Exercise;
import edu.colostate.cs.cs414.tba.domain.Insurance;
import edu.colostate.cs.cs414.tba.domain.PersonalInformation;
import edu.colostate.cs.cs414.tba.domain.WorkoutRoutine;

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
	public void testGetAssignedCustomers() throws IOException {
		Set<Customer> emptyCustomers = new HashSet<Customer>();
		assertEquals(true, emptyCustomers.equals(workoutRoutine.getAssignedCustomers()));
	}
	
	@Test
	public void testAssignCustomer() throws IOException {
		Set<Customer> customersTest = new HashSet<Customer>();
		Customer customer = new Customer("username", "pass");
		customersTest.add(customer);
		workoutRoutine.assignCustomer(customer);
		assertEquals(true, customersTest.equals(workoutRoutine.getAssignedCustomers()));
	}
	
	@Test
	public void testGetExercises() throws IOException {
		Set<Exercise> emptyExercises = new HashSet<Exercise>();
		assertEquals(true, emptyExercises.equals(workoutRoutine.getExercises()));
	}
	
	@Test
	public void testSetExercises() throws IOException {
		Set<Exercise> newExercises = new HashSet<Exercise>();
		Exercise exercise = new Exercise("Bench", "1 min", 4, 10, null);
		newExercises.add(exercise);
		workoutRoutine.addExercise(exercise);
		assertEquals(true, newExercises.equals(workoutRoutine.getExercises()));
	}
}
