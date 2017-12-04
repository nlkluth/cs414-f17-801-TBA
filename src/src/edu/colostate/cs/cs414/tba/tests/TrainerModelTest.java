package edu.colostate.cs.cs414.tba.tests;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import edu.colostate.cs.cs414.tba.domain.PersonalInformation;
import edu.colostate.cs.cs414.tba.domain.Trainer;
import edu.colostate.cs.cs414.tba.models.TrainerModel;

public class TrainerModelTest {
	private TrainerModel trainerModel;
	
	@Before public void setUp() {
		trainerModel = TrainerModel.getInstance();
		while (trainerModel.get().size() != 0) {
			Trainer trainer = trainerModel.get().iterator().next();
			trainerModel.remove(trainer);
		}
	}
	
	@Test
	public void testGetEmpty() throws IOException {
		Set<Trainer> emptySet = new HashSet<Trainer>();
		Set<Trainer> trainerSet = trainerModel.get();
		assertEquals(true, emptySet.equals(trainerSet));	
	}
  
	@Test
	public void testGetItemEmpty() throws IOException {
		// returns null if item isn't found
		Trainer trainer = new Trainer("username", "pass");
		Trainer found = trainerModel.getIndividual(trainer);
		assertEquals(null, found);
	}
  
	@Test
	public void testAddItem() throws IOException {
		Trainer trainer = new Trainer("username", "pass");
		trainerModel.add(trainer);
		assertEquals(1, trainerModel.get().size());
	}
  
	@Test
	public void testGetItem() throws IOException {
		Trainer trainer = new Trainer("username", "pass");
		trainerModel.add(trainer);
		Trainer found = trainerModel.getIndividual(trainer);
		assertEquals(true, found.equals(trainer));
	}
  
	@Test
	public void testGetNotEmpty() throws IOException {
		Trainer trainer = new Trainer("username", "pass");
		trainerModel.add(trainer);
		
		Trainer trainer2 = new Trainer("username2", "pass");
		trainerModel.add(trainer2);
		
		assertEquals(2, trainerModel.get().size());
	}
  
	@Test
	public void testRemove() throws IOException {
		Trainer trainer = new Trainer("username", "pass");
		trainerModel.add(trainer);
		
		Trainer trainer2 = new Trainer("username2", "pass");
		trainerModel.add(trainer2);
		
		Trainer trainer3 = new Trainer("username3", "pass");
		trainerModel.add(trainer3);
		
		trainerModel.remove(trainer2);
		assertEquals(null, trainerModel.getIndividual(trainer2));
		assertEquals(true, trainerModel.getIndividual(trainer).equals(trainer));
	}
}
