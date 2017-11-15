package edu.colostate.cs.cs414.tba.tests;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import edu.colostate.cs.cs414.tba.domain.Equipment;
import edu.colostate.cs.cs414.tba.domain.Exercise;

public class EquipmentTest {
	private Equipment equipment;
	private Exercise exercise;
	private File img;
	
	@Before public void setUp() {
		img = new File("test.png");
		equipment = new Equipment("Bench Press", img, "Excellent");
		exercise = new Exercise("Warmup", "3 minutes", 4, 10, null);
		equipment.addExercise(exercise);
	}
	
	@Test
	public void testAddExercise() throws IOException {
		Exercise newExercise = new Exercise("HIIT", "2 minutes", 4, 15, null);
		equipment.addExercise(newExercise);
		assertEquals(2, equipment.getExercises().size());
		assertEquals(true, equipment.getExercises().contains(newExercise));
	}
	
	@Test
	public void testGetExercise() throws IOException {
		assertEquals(true, equipment.getExercises().contains(exercise));
	}
	
	@Test
	public void testToString() throws IOException {
		assertEquals("Bench Press : Excellent", equipment.toString());
	}
	
	@Test
	public void testGetImage() throws IOException {
		assertEquals(true, img.equals(equipment.getImage()));
	}
}
