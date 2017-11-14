package edu.colostate.cs.cs414.tba.tests;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import edu.colostate.cs.cs414.tba.gymmanagement.Address;
import edu.colostate.cs.cs414.tba.gymmanagement.Insurance;

public class InsuranceTest {
	private Insurance insurance;
	
	@Before public void setUp() {
		// create new instance of insurance for tests
		insurance = new Insurance("Blue Cross", new Address("1234", "2", "Denver", "CO", "80231"));
	}
	
	@Test
	public void testGetName() throws IOException {
		assertEquals("Blue Cross", insurance.getName());
	}
	
	@Test
	public void testGetAddress() throws IOException {
		assertEquals("1234 2, Denver CO, 80231", insurance.getAddress().toString());
	}
	
	@Test
	public void testToString() throws IOException {
		assertEquals("Blue Cross:\n1234 2, Denver CO, 80231", insurance.toString());
	}
	
	@Test
	public void testEquals() throws IOException {
		Insurance otherInsurance = new Insurance("Blue Cross", new Address("1234", "2", "Denver", "CO", "80231"));
		Insurance thirdInsurance = new Insurance("Blue Shield", new Address("1234", "2", "Denver", "CO", "80231"));
		assertEquals(true, insurance.equals(otherInsurance));
		assertEquals(false, insurance.equals(thirdInsurance));
	}
}
