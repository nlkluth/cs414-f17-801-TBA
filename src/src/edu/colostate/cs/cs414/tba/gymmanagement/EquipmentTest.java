package edu.colostate.cs.cs414.tba.gymmanagement;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class EquipmentTest {
	private Equipment equipment;
	private File img;
	
	@Before public void setUp() {
		img = new File("test.png");
		equipment = new Equipment("Bench Press", img, "Excellent");
		equipment.addExercise(new Exercise("Warmup", "3 minutes", 4, 10));
	}
	
	@Test
	public void testAddExercise() throws IOException {
		equipment.addExercise(new Exercise("HIIT", "2 minutes", 4, 15));
		assertEquals(2, equipment.getExercises().size());
		assertEquals("HIIT : 2 minutes : 15 reps : 4 sets", equipment.getExercises().toArray()[1].toString());
	}
	
	@Test
	public void testGetExercise() throws IOException {
		assertEquals("Warmup : 3 minutes : 10 reps : 4 sets", equipment.getExercises().toArray()[0].toString());
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
