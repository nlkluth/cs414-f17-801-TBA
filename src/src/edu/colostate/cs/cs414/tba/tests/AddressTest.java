package edu.colostate.cs.cs414.tba.tests;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import edu.colostate.cs.cs414.tba.gymmanagement.Address;

public class AddressTest {
	private Address address;
	
	@Before public void setUp() {
		// create new instance of address of tests
		address = new Address("1234 S Spruce St.", "Unit 22", "Denver", "CO", "80231");
	}
	
	@Test
	public void testToString() throws IOException {
		// Get full address
		assertEquals("1234 S Spruce St. Unit 22, Denver CO, 80231", address.toString());
	}
	
	@Test
	public void testGetStreet() throws IOException {
		assertEquals("1234 S Spruce St. Unit 22", address.getStreet());
	}
	
	@Test
	public void testGetCity() throws IOException {
		assertEquals("Denver", address.getCity());
	}
	
	@Test
	public void testGetState() throws IOException {
		assertEquals("CO", address.getState());
	}
	
	@Test
	public void testGetZip() throws IOException {
		assertEquals("80231", address.getZip());
	}
}
