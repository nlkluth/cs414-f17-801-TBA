package edu.colostate.cs.cs414.tba.tests;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import edu.colostate.cs.cs414.tba.controllers.WorkoutRoutineController;
import edu.colostate.cs.cs414.tba.domain.WorkoutRoutine;

public class WorkoutRoutineControllerTest {
	private WorkoutRoutineController controller;
	
	@Before public void setUp() {
		controller = new WorkoutRoutineController();
		// clear out any routines to get back to empty
		for (WorkoutRoutine workout : controller.getAll()) {
			controller.delete(workout);
		}
	}
	
	@Test
	public void testGetAllEmpty() throws IOException {		
		Set<WorkoutRoutine> emptySet = new HashSet<WorkoutRoutine>();
		Set<WorkoutRoutine> found = controller.getAll();
		assertEquals(true, found.equals(emptySet));
	}
	
	@Test
	public void testCreate() throws IOException {
		controller.create("Test");
		assertEquals(1, controller.getAll().size());
	}
	
	@Test
	public void testGetById() throws IOException {
		WorkoutRoutine workout = controller.create("Test");
		WorkoutRoutine found = controller.get(workout.getId());
		assertEquals(true, found.equals(workout));
	}
	
	@Test
	public void testGetByObject() throws IOException {
		WorkoutRoutine workout = controller.create("Test");
		WorkoutRoutine found = controller.get(workout);
		assertEquals(true, found.equals(workout));
	}
	
	@Test
	public void testGetAll() throws IOException {
		controller.create("Test");
		assertEquals(1, controller.getAll().size());
	}
	
	@Test
	public void testDeleteBObject() throws IOException {
		WorkoutRoutine workout = controller.create("Test");
		controller.delete(workout);
		WorkoutRoutine found = controller.get(workout);
		assertEquals(null, found);
	}
}
