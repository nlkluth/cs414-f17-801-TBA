package edu.colostate.cs.cs414.tba.tests;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import edu.colostate.cs.cs414.tba.controllers.ExerciseController;
import edu.colostate.cs.cs414.tba.domain.Exercise;

public class ExerciseControllerTest {
	private ExerciseController controller;
	
	@Before public void setUp() {
		controller = new ExerciseController();
		// clear out any exercises to get back to empty
		for (Exercise exercise : controller.getAll()) {
			controller.delete(exercise);
		}
	}
	
	@Test
	public void testCreate() throws IOException {
		controller.create("Test", "", 0, 0, null);
		assertEquals(1, controller.getAll().size());
	}
	
	@Test
	public void testGetById() throws IOException {
		Exercise exercise = controller.create("Test", "", 0, 0, null);
		Exercise found = controller.get(exercise.getId());
		assertEquals(true, found.equals(exercise));
	}
	
	@Test
	public void testGetByObject() throws IOException {
		Exercise exercise = controller.create("Test", "", 0, 0, null);
		Exercise found = controller.get(exercise);
		assertEquals(true, found.equals(exercise));
	}
	
	@Test
	public void testGetAll() throws IOException {
		controller.create("Test", "", 0, 0, null);
		assertEquals(1, controller.getAll().size());
	}
	
	@Test
	public void testDeleteBObject() throws IOException {
		Exercise exercise = controller.create("Test", "", 0, 0, null);
		controller.delete(exercise);
		Exercise found = controller.get(exercise);
		assertEquals(null, found);
	}
}
