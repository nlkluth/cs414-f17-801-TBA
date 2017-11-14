package edu.colostate.cs.cs414.tba.tests;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import edu.colostate.cs.cs414.tba.gymmanagement.Address;
import edu.colostate.cs.cs414.tba.gymmanagement.Insurance;
import edu.colostate.cs.cs414.tba.gymmanagement.PersonalInformation;
import edu.colostate.cs.cs414.tba.gymmanagement.Qualification;
import edu.colostate.cs.cs414.tba.gymmanagement.Trainer;

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
		Trainer trainer = new Trainer("user", "Password",
			new PersonalInformation("Test", "User", "555-555-5555", "test@example.com"),
			new Address("123", "4", "Denver", "CO", "80231"),
			new Insurance("Blue Cross", new Address("123", "4", "Denver", "CO", "80211"))
		);
		Set<Trainer> testSet = new HashSet<Trainer>();
		testSet.add(trainer);
		qualification.addTrainer(trainer);
		assertEquals(true, testSet.equals(qualification.getTrainers()));
	}
}
