package edu.colostate.cs.cs414.tba.tests;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import edu.colostate.cs.cs414.tba.controllers.TrainerController;
import edu.colostate.cs.cs414.tba.domain.PersonalInformation;
import edu.colostate.cs.cs414.tba.domain.Trainer;

public class TrainerControllerTest {
	private TrainerController controller;
	
	@Before public void setUp() {
		controller = new TrainerController();
		// clear out any trainers to get back to empty
		for (Trainer trainer : controller.getAll()) {
			controller.delete(trainer);
		}
	}
	
	@Test
	public void testCreate() throws IOException {
		Set<Trainer> emptySet = new HashSet<Trainer>();
		Set<Trainer> found = controller.getAll();
		assertEquals(true, found.equals(emptySet));
	}
	
	@Test
	public void testGetById() throws IOException {
		Trainer trainer = controller.create("Test", "pass");
		Trainer found = controller.get(trainer.getId());
		assertEquals(true, found.equals(trainer));
	}
	
	@Test
	public void testGetByObject() throws IOException {
		Trainer trainer = controller.create("Test", "pass");
		Trainer found = controller.get(trainer);
		assertEquals(true, found.equals(trainer));
	}
	
	@Test
	public void testGetAll() throws IOException {
		controller.create("Test", "pass");
		
		controller.create("Test2", "pass2");
		
		assertEquals(2, controller.getAll().size());
	}
	
	@Test
	public void testDeleteByObject() throws IOException {
		Trainer trainer = controller.create("Test", "pass");
		
		controller.create("Test2", "pass2");
		
		controller.delete(trainer);
		assertEquals(1, controller.getAll().size());
	}
}
