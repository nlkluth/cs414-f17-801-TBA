package edu.colostate.cs.cs414.tba.gymmanagement;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class AddressTest {
	private Address address;
	
	@Before public void setUp() {
		// create new instance of address of tests
		address = new Address();
	}
	
	@Test
	public void testToString() throws IOException {
		// Get full address
		assertEquals("1234 S Spruce St. Unit 22, Denver CO, 80231", address.toString());
	}
}
