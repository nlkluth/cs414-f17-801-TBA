package edu.colostate.cs.cs414.tba.gymmanagement;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class CustomerTest {
	private Customer customer;
	
	@Before public void setUp() {
		customer = new Customer(
				new PersonalInformation("Nathan", "Kluth", "555-555-5555", "test@example.com"),
				new Address("1234", "4", "Denver", "CO", "80231"),
				new Insurance("Blue Cross", new Address("1234", "4", "Denver", "CO", "80231"))
				);
	}
	
	@Test
	public void testGetPersonalInformation() {
		assertEquals("User: Nathan Kluth\nphone: 555-555-5555\nemail: test@example.com", customer.getPersonalInformation().toString());
	}
	
	@Test
	public void testUpdate() {
		customer.update(
				new PersonalInformation("Test", "User", "444-444-4444", "test@example.com"),
				new Address("234", "4", "Denver", "CO", "80222"),
				new Insurance("Blue Cross", new Address("4444", "4", "Fort Collins", "CO", "80122"))
				);
		
		assertEquals("User: Test User\nphone: 444-444-4444\nemail: test@example.com", customer.getPersonalInformation().toString());
		assertEquals("234 4, Denver CO, 80222", customer.getAddress().toString());
		assertEquals("Blue Cross:\n4444 4, Fort Collins CO, 80122", customer.getInsurance().toString());
	}
	
	@Test
	public void testGetAddress() {
		assertEquals("1234 4, Denver CO, 80231", customer.getAddress().toString());
	}
	
	@Test
	public void testGetInsurance() {
		assertEquals("Blue Cross:\n1234 4, Denver CO, 80231", customer.getInsurance().toString());
	}
	
	@Test
	public void testGetWorkoutRoutines() {
		Set<WorkoutRoutine> emptyWorkouts = new HashSet<WorkoutRoutine>();
		assertEquals(true, emptyWorkouts.equals(customer.getWorkoutRoutines()));
	}
	
	@Test
	public void testAssignToWorkoutRoutine() {
		Set<WorkoutRoutine> workouts = new HashSet<WorkoutRoutine>();
		WorkoutRoutine workout = new WorkoutRoutine("Workout2");
		workouts.add(workout);
		customer.addWorkoutRoutine(workout);
		assertEquals(true, workouts.equals(customer.getWorkoutRoutines()));
	}
	
	@Test
	public void testGetMembership() {
		assertEquals(Membership.ACTIVE, customer.getMembership());
	}
	
	@Test
	public void testSetMembership() {
		customer.setActive(Membership.INACTIVE);
		assertEquals(Membership.INACTIVE, customer.getMembership());
	}
}
