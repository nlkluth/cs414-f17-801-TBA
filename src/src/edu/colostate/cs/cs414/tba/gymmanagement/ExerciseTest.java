package edu.colostate.cs.cs414.tba.gymmanagement;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class ExerciseTest {
	private Exercise exercise;
	
	@Before public void setUp() {
		exercise = new Exercise("Jumping jacks", "1 min", 3, 15);
	}
	
	@Test
	public void testToString() throws IOException {
		assertEquals("Jumping jacks : 1 min : 15 reps : 3 sets", exercise.toString());
	}
	
	@Test
	public void testUpdate() throws IOException {
		exercise.update("Jumping Jacks", "2 min", 4, 20);
		assertEquals("Jumping Jacks : 2 min : 20 reps : 4 sets", exercise.toString());
	}
	
	@Test
	public void testGetName() throws IOException {
		assertEquals("Jumping jacks", exercise.getName());
	}
	
	@Test
	public void testGetDuration() throws IOException {
		assertEquals("1 min", exercise.getDuration());
	}
	
	@Test
	public void testGetSets() throws IOException {
		assertEquals(3, exercise.getSets());
	}
	
	@Test
	public void testGetReps() throws IOException {
		assertEquals(15, exercise.getReps());
	}
	
	@Test
	public void testSetName() throws IOException {
		exercise.setName("Other");
		assertEquals("Other", exercise.getName());
	}
	
	@Test
	public void testSetDuration() {
		exercise.setDuration("2 min");
		assertEquals("2 min", exercise.getDuration());
	}
	
	@Test
	public void testSetSets() throws IOException {
		exercise.setSets(200);
		assertEquals(200, exercise.getSets());
	}
	
	@Test 
	public void testSetReps() throws IOException {
		exercise.setReps(1);
		assertEquals(1, exercise.getReps());
	}
	
	@Test
	public void testAddEquipment() throws IOException {
		Equipment equipment = new Equipment("Barbell", new File("./barbell.png"), "Low");
		exercise.setEquipment(equipment);
		assertEquals(true, equipment.equals(exercise.getEquipment()));
	}
}
