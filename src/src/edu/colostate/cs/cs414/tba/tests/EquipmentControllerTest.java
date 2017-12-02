package edu.colostate.cs.cs414.tba.tests;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import edu.colostate.cs.cs414.tba.controllers.EquipmentController;
import edu.colostate.cs.cs414.tba.domain.Equipment;

public class EquipmentControllerTest {
	private EquipmentController controller;
	
	@Before public void setUp() {
		controller = new EquipmentController();
		// clear out any equipment to get back to empty
		for (Equipment equipment : controller.getAll()) {
			controller.delete(equipment);
		}
	}
	
	@Test
	public void testCreate() throws IOException {
		controller.create("Test", new File("./test.png"), "Good");
		assertEquals(1, controller.getAll().size());
	}
	
	@Test
	public void testGetAllEmpty() throws IOException {
		Set<Equipment> emptySet = new HashSet<Equipment>();
		Set<Equipment> found = controller.getAll();
		assertEquals(true, found.equals(emptySet));
	}
	
	@Test
	public void testGetById() throws IOException {
		Equipment equipment = controller.create("Test", new File("./test.png"), "Good");
		Equipment found = controller.get(equipment.getId());
		assertEquals(true, equipment.equals(found));
	}
	
	@Test
	public void testGetByObject() throws IOException {
		Equipment equipment = controller.create("Test", new File("./test.png"), "Good");
		Equipment found = controller.get(equipment);
		assertEquals(true, found.equals(equipment));
	}
	
	@Test
	public void testGetAll() throws IOException {
		controller.create("Test", new File("./test.png"), "Good");
		controller.create("Test2", new File("./test.png"), "Good");
		assertEquals(2, controller.getAll().size());
	}
	
	@Test
	public void testDeleteBObject() throws IOException {
		Equipment equipment = controller.create("Test", new File("./test.png"), "Good");
		controller.delete(equipment);
		Equipment found = controller.get(equipment);
		assertEquals(null, found);
	}
}
