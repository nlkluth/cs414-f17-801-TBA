package edu.colostate.cs.cs414.tba.tests;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import edu.colostate.cs.cs414.tba.gymmanagement.PersonalInformation;

public class PersonalInformationTest {
	private PersonalInformation personalInformation;
	
	@Before public void setUp() {
		// create new instance of PersonalInformation for tests
		personalInformation = new PersonalInformation("Nathan", "Kluth", "555-555-5555", "nathan@test.com");
	}
	
	@Test
	public void testToString() throws IOException {
		// get full personal information
		assertEquals("User: Nathan Kluth\nphone: 555-555-5555\nemail: nathan@test.com", personalInformation.toString());
	}
	
	@Test
	public void geName() throws IOException {
		assertEquals("Nathan Kluth", personalInformation.getName());
	}
	
	@Test
	public void getPhone() throws IOException {
		assertEquals("555-555-5555", personalInformation.getPhone());
	}
	
	@Test
	public void getEmail() throws IOException {
		assertEquals("nathan@test.com", personalInformation.getEmail());
	}
}
