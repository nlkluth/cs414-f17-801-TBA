package edu.colostate.cs.cs414.tba.tests;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import edu.colostate.cs.cs414.tba.domain.WorkoutRoutine;
import edu.colostate.cs.cs414.tba.models.WorkoutRoutineModel;

public class WorkoutRoutineModelTest {
	private WorkoutRoutineModel workoutRoutineModel;
	
	@Before public void setUp() {
		workoutRoutineModel = WorkoutRoutineModel.getInstance();
	}
	
	@Test
	public void testGetEmpty() throws IOException {
		Set<WorkoutRoutine> emptySet = new HashSet<WorkoutRoutine>();
		Set<WorkoutRoutine> set = workoutRoutineModel.get();
		assertEquals(true, emptySet.equals(set));
	}
	
	@Test
	public void testGetItemEmpty() throws IOException {
		// returns a null if item isn't found
		WorkoutRoutine workout = new WorkoutRoutine("Test");
		assertEquals(null, workoutRoutineModel.getIndividual(workout));
	}
	
	@Test
	public void testAddItem() throws IOException {
		WorkoutRoutine workout = new WorkoutRoutine("Test");
		workoutRoutineModel.add(workout);
		assertEquals(1, workoutRoutineModel.get().size());
	}
	
	@Test
	public void testGetItem() throws IOException {
		WorkoutRoutine workout = new WorkoutRoutine("Test");
		workoutRoutineModel.add(workout);
		WorkoutRoutine found = workoutRoutineModel.getIndividual(workout);
		assertEquals(true, found.equals(workout));
	}
	
	@Test
	public void testGetNotEmpty() throws IOException {
		WorkoutRoutine workout = new WorkoutRoutine("Test");
		workoutRoutineModel.add(workout);

		WorkoutRoutine workout2 = new WorkoutRoutine("Test2");
		workoutRoutineModel.add(workout2);
		
		assertEquals(3, workoutRoutineModel.get().size());
	}
	
	@Test
	public void testRemove() throws IOException {
		WorkoutRoutine workout = new WorkoutRoutine("Test");
		workoutRoutineModel.add(workout);
		
		WorkoutRoutine workout2 = new WorkoutRoutine("Test2");
		workoutRoutineModel.add(workout2);
		
		WorkoutRoutine workout3 = new WorkoutRoutine("Test3");
		workoutRoutineModel.add(workout3);
		
		workoutRoutineModel.remove(workout2);
		assertEquals(null, workoutRoutineModel.getIndividual(workout2));
		assertEquals(true, workoutRoutineModel.getIndividual(workout).equals(workout));
	}
}
