package edu.colostate.cs.cs414.tba.tests;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import edu.colostate.cs.cs414.tba.gymmanagement.Address;
import edu.colostate.cs.cs414.tba.gymmanagement.Availability;
import edu.colostate.cs.cs414.tba.gymmanagement.Insurance;
import edu.colostate.cs.cs414.tba.gymmanagement.PersonalInformation;
import edu.colostate.cs.cs414.tba.gymmanagement.Trainer;

public class TrainerTest {
	private Trainer trainer;
	
	@Before public void setUp() {
		trainer = new Trainer("user", "password",
				new PersonalInformation("Nathan", "Kluth", "555-555-5555", "test@example.com"),
				new Address("2345", "4", "Denver", "CO", "80231"),
				new Insurance("Blue Cross", new Address("234", "4", "Denver", "CO", "80231"))
				);
	}
	
	@Test
	public void testUpdate() throws IOException {
		trainer.update(
				new PersonalInformation("Test", "User", "444-444-4444", "Test@example.com"),
				new Address("2424", "4", "Denver", "CO", "80122"),
				new Insurance("eawf aewf", new Address("234", "4", "Denver", "CO", "80231"))
				);
		
		assertEquals("User: Test User\nphone: 444-444-4444\nemail: Test@example.com", trainer.getPersonalInformation().toString());
		assertEquals("2424 4, Denver CO, 80122", trainer.getAddress().toString());
		assertEquals("eawf aewf:\n234 4, Denver CO, 80231", trainer.getInsurance().toString());
	}
	
	@Test
	public void testGetUsername() throws IOException {
		assertEquals("user", trainer.getUsername());
	}
	
	@Test
	public void testGetPassword() throws IOException {
		assertEquals("password", trainer.getPassword());
	}
	
	@Test
	public void testGetPersonalInformation() throws IOException {
		assertEquals("User: Nathan Kluth\nphone: 555-555-5555\nemail: test@example.com", trainer.getPersonalInformation().toString());
	}
	
	@Test
	public void testGetInsurance() throws IOException {
		assertEquals("Blue Cross:\n234 4, Denver CO, 80231", trainer.getInsurance().toString());
	}
	
	@Test
	public void testGetAddress() throws IOException {
		assertEquals("2345 4, Denver CO, 80231", trainer.getAddress().toString());
	}
	
	@Test
	public void testGetAvailability() throws IOException {
		assertEquals(Availability.FULLTIME, trainer.getAvailability());
	}
	
	@Test
	public void testSetAvailability() throws IOException {
		trainer.setAvailability(Availability.PARTTIME);
		assertEquals(Availability.PARTTIME, trainer.getAvailability());
	}
}
