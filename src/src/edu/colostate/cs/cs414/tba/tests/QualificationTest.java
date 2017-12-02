package edu.colostate.cs.cs414.tba.tests;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import edu.colostate.cs.cs414.tba.domain.Address;
import edu.colostate.cs.cs414.tba.domain.Insurance;
import edu.colostate.cs.cs414.tba.domain.PersonalInformation;
import edu.colostate.cs.cs414.tba.domain.Qualification;
import edu.colostate.cs.cs414.tba.domain.Trainer;

public class QualificationTest {
	private Qualification qualification;
	
	@Before public void setUp() {
		qualification = new Qualification("Leadership");
	}
	
	@Test
	public void testToString() throws IOException {
		assertEquals("Leadership", qualification.toString());
	}
	
	@Test 
	public void testGetTrainer() throws IOException {
		Set<Trainer> emptySet = new HashSet<Trainer>();
		assertEquals(true, emptySet.equals(qualification.getTrainers()));
	}
	
	@Test
	public void testAddTrainer() throws IOException {
		Trainer trainer = new Trainer("username", "pass");
		Set<Trainer> testSet = new HashSet<Trainer>();
		testSet.add(trainer);
		qualification.addTrainer(trainer);
		assertEquals(true, testSet.equals(qualification.getTrainers()));
	}
}
