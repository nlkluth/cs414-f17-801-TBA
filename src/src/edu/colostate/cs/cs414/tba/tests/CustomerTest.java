package edu.colostate.cs.cs414.tba.tests;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import edu.colostate.cs.cs414.tba.domain.Address;
import edu.colostate.cs.cs414.tba.domain.Customer;
import edu.colostate.cs.cs414.tba.domain.Insurance;
import edu.colostate.cs.cs414.tba.domain.PersonalInformation;
import edu.colostate.cs.cs414.tba.domain.WorkoutRoutine;
import edu.colostate.cs.cs414.tba.gymmanagement.Membership;

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
	public void testGetPersonalInformation() throws IOException {
		assertEquals("User: Nathan Kluth\nphone: 555-555-5555\nemail: test@example.com", customer.getPersonalInformation().toString());
	}
	
	@Test
	public void testUpdate() throws IOException {
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
	public void testGetAddress() throws IOException {
		assertEquals("1234 4, Denver CO, 80231", customer.getAddress().toString());
	}
	
	@Test
	public void testGetInsurance() throws IOException {
		assertEquals("Blue Cross:\n1234 4, Denver CO, 80231", customer.getInsurance().toString());
	}
	
	@Test
	public void testGetWorkoutRoutines() throws IOException {
		Set<WorkoutRoutine> emptyWorkouts = new HashSet<WorkoutRoutine>();
		assertEquals(true, emptyWorkouts.equals(customer.getWorkoutRoutines()));
	}
	
	@Test
	public void testAssignToWorkoutRoutine() throws IOException {
		Set<WorkoutRoutine> workouts = new HashSet<WorkoutRoutine>();
		WorkoutRoutine workout = new WorkoutRoutine("Workout2");
		workouts.add(workout);
		customer.addWorkoutRoutine(workout);
		assertEquals(true, workouts.equals(customer.getWorkoutRoutines()));
	}
	
	@Test
	public void testGetMembership() throws IOException {
		assertEquals(Membership.ACTIVE, customer.getMembership());
	}
	
	@Test
	public void testSetMembership() throws IOException {
		customer.setActive(Membership.INACTIVE);
		assertEquals(Membership.INACTIVE, customer.getMembership());
	}
}
