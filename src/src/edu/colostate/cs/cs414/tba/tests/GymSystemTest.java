package edu.colostate.cs.cs414.tba.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import edu.colostate.cs.cs414.tba.services.GymSystem;

public class GymSystemTest {
	private GymSystem gymSystem;
	
	@Before public void setUp() {
		gymSystem = new GymSystem();
	}
	
	// Tests for gym system setup and overall changes would go here
	// currently in this light implementation there are none
	@Test
	public void testInit() {
		assertEquals(true, true);
	}
}
