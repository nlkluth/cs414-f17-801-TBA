package edu.colostate.cs.cs414.tba.tests;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import edu.colostate.cs.cs414.tba.domain.Qualification;
import edu.colostate.cs.cs414.tba.models.QualificationModel;

public class QualificationModelTest {
	private QualificationModel qualificationModel;
	
	@Before public void setUp() {
		qualificationModel = QualificationModel.getInstance();
		while (qualificationModel.get().size() != 0) {
			Qualification qualification = qualificationModel.get().iterator().next();
			qualificationModel.remove(qualification);
		}
	}
	
	@Test
	public void testGetEmpty() throws IOException {
		Set<Qualification> emptySet = new HashSet<Qualification>();
		Set<Qualification> foundSet = qualificationModel.get();
		assertEquals(true, emptySet.equals(foundSet));
	}
	
	@Test
	public void testGetItemEmpty() throws IOException {
		Qualification qualification = new Qualification("not found");
		Qualification found = qualificationModel.getIndividual(qualification);
		assertEquals(null, found);
	}
	
	@Test
	public void testAddItem() throws IOException {
		Qualification qualification = new Qualification("Test");
		qualificationModel.add(qualification);
		assertEquals(1, qualificationModel.get().size());
	}
	
	@Test
	public void testGetItem() throws IOException {
		Qualification qualification = new Qualification("Test");
		qualificationModel.add(qualification);
		Qualification found = qualificationModel.getIndividual(qualification);
		assertEquals(true, found.equals(qualification));
	}
	
	@Test
	public void testGetNotEmpty() throws IOException {
		Qualification q1 = new Qualification("Test");
		qualificationModel.add(q1);
		
		Qualification q2 = new Qualification("Test2");
		qualificationModel.add(q2);
		
		assertEquals(2, qualificationModel.get().size());
	}
	
	@Test
	public void testRemove() throws IOException {
		Qualification q1 = new Qualification("Test");
		qualificationModel.add(q1);
		
		Qualification q2 = new Qualification("Test2");
		qualificationModel.add(q2);		;
		
		Qualification q3 = new Qualification("Test3");
		qualificationModel.add(q3);
		
		qualificationModel.remove(q1);
		assertEquals(null, qualificationModel.getIndividual(q1));
		assertEquals(true, qualificationModel.getIndividual(q2).equals(q2));
	}
}
