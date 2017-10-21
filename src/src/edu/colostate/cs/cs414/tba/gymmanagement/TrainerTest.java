package edu.colostate.cs.cs414.tba.gymmanagement;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class TrainerTest {
	private Trainer trainer;
	
	@Before public void setUp() {
		trainer = new Trainer(
				new PersonalInformation("Nathan", "Kluth", "555-555-5555", "test@example.com"),
				new Address("2345", "4", "Denver", "CO", "80231"),
				new Insurance("Blue Cross", new Address("234", "4", "Denver", "CO", "80231"))
				);
	}
	
	@Test
	public void testUpdate() {
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
	public void testGetPersonalInformation() {
		assertEquals("User: Nathan Kluth\nphone: 555-555-5555\nemail: test@example.com", trainer.getPersonalInformation().toString());
	}
	
	@Test
	public void testGetInsurance() {
		assertEquals("Blue Cross:\n234 4, Denver CO, 80231", trainer.getInsurance().toString());
	}
	
	@Test
	public void testGetAddress() {
		assertEquals("2345 4, Denver CO, 80231", trainer.getAddress().toString());
	}
	
	@Test
	public void testGetAvailability() {
		assertEquals(Availability.FULLTIME, trainer.getAvailability());
	}
	
	@Test
	public void testSetAvailability() {
		trainer.setAvailability(Availability.PARTTIME);
		assertEquals(Availability.PARTTIME, trainer.getAvailability());
	}
}
