package edu.colostate.cs.cs414.tba.tests;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import edu.colostate.cs.cs414.tba.controllers.QualificationController;
import edu.colostate.cs.cs414.tba.domain.Qualification;
import edu.colostate.cs.cs414.tba.domain.Trainer;

public class QualificationControllerTest {
	private QualificationController controller;
	private Trainer trainer;
	
	@Before public void setUp() {
		controller = new QualificationController();
		trainer = new Trainer("useranme", "password");
		
		// clear out qualifications for fresh start each test
		for (Qualification qualification : controller.getAll()) {
			controller.delete(qualification);
		}
	}
	
	@Test
	public void testCreate() throws IOException {
		controller.create("Test", trainer);
		assertEquals(1, controller.getAll().size());
	}
	
	@Test
	public void testGetAllEmpty() throws IOException {
		Set<Qualification> emptySet = new HashSet<Qualification>();
		Set<Qualification> found = new HashSet<Qualification>();
		assertEquals(true, found.equals(emptySet));
	}
	
	@Test
	public void testGetById() throws IOException {
		Qualification qualification = controller.create("Test", trainer);
		Qualification found = controller.get(qualification.getId());
		assertEquals(true, found.equals(qualification));
	}
	
	@Test
	public void testGetByObject() throws IOException {
		Qualification qualification = controller.create("Test", trainer);
		Qualification found = controller.get(qualification);
		assertEquals(true, found.equals(qualification));
	}
	
	@Test
	public void testGetAll() throws IOException {
		controller.create("Test", trainer);
		controller.create("Test2", trainer);
		assertEquals(2, controller.getAll().size());
	}
	
	@Test
	public void testDeleteByObject() throws IOException {
		Qualification qualification = controller.create("Test", trainer);
		controller.delete(qualification);
		Qualification found = controller.get(qualification);
		assertEquals(null, found);
	}
}
