package edu.colostate.cs.cs414.tba.tests;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import edu.colostate.cs.cs414.tba.domain.Exercise;
import edu.colostate.cs.cs414.tba.models.ExerciseModel;

public class ExerciseModelTest {
	private ExerciseModel exerciseModel;
	
	@Before public void setUp() {
		exerciseModel = ExerciseModel.getInstance();
	}
	
	@Test
	public void testGetEmpty() throws IOException {
		Set<Exercise> emptySet = new HashSet<Exercise>();
		Set<Exercise> set = exerciseModel.get();
		assertEquals(true, emptySet.equals(set));
	}

	@Test
	public void testGetItemEmpty() throws IOException {
		// returns a null if item isn't found
		Exercise exercise = new Exercise("Exercise", null, 0, 0, null);
		assertEquals(null, exerciseModel.getIndividual(exercise));
	}

	@Test
	public void testAddItem() throws IOException {
		Exercise exercise = new Exercise("Exercise", null, 0, 0, null);
		exerciseModel.add(exercise);
		assertEquals(1, exerciseModel.get().size());
	}

	@Test
	public void testGetItem() throws IOException {
		Exercise exercise = new Exercise("Exercise", null, 0, 0, null);
		exerciseModel.add(exercise);
		Exercise found = exerciseModel.getIndividual(exercise);
		assertEquals(true, found.equals(exercise));
	}

	@Test
	public void testGetNotEmpty() throws IOException {
		Exercise exercise = new Exercise("Exercise", null, 0, 0, null);
		exerciseModel.add(exercise);
		
		Exercise exercise2 = new Exercise("Exercise2", null, 0, 0, null);
		exerciseModel.add(exercise2);
		
		assertEquals(3, exerciseModel.get().size());
	}

	@Test
	public void testRemove() throws IOException {
		Exercise exercise = new Exercise("Exercise", null, 0, 0, null);
		exerciseModel.add(exercise);
		
		Exercise exercise2 = new Exercise("Exercise2", null, 0, 0, null);
		exerciseModel.add(exercise2);
		
		Exercise exercise3 = new Exercise("Exercise3", null, 0, 0, null);
		exerciseModel.add(exercise3);
		
		exerciseModel.remove(exercise2);
		assertEquals(null, exerciseModel.getIndividual(exercise2));
		assertEquals(true, exerciseModel.getIndividual(exercise).equals(exercise));
	}
}
