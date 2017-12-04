package edu.colostate.cs.cs414.tba.tests;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import edu.colostate.cs.cs414.tba.domain.Equipment;
import edu.colostate.cs.cs414.tba.models.EquipmentModel;

public class EquipmentModelTest {
	private EquipmentModel equipmentModel;
	
	@Before public void setUp() {  
		equipmentModel = EquipmentModel.getInstance();
		while (equipmentModel.get().size() != 0) {
			Equipment eq = equipmentModel.get().iterator().next();
			equipmentModel.remove(eq);			
		}
	}
	
	@Test
	public void testGetEmpty() throws IOException {
		Set<Equipment> emptySet = new HashSet<Equipment>();
		Set<Equipment> set = equipmentModel.get();
		assertEquals(true, emptySet.equals(set));
	}

	@Test
	public void testGetItemEmpty() throws IOException {
		// returns a null if item isn't found
		Equipment equipment = new Equipment("Test", new File("File.png"), "Good");
		assertEquals(null, equipmentModel.getIndividual(equipment));
	}

	@Test
	public void testAddItem() throws IOException {
		Equipment equipment = new Equipment("T", new File("T.png"), "Good");
		equipmentModel.add(equipment);
		assertEquals(1, equipmentModel.get().size());
	}

	@Test
	public void testGetItem() throws IOException {
		Equipment equipment = new Equipment("T", new File("T.png"), "Good");
		equipmentModel.add(equipment);
		Equipment found = equipmentModel.getIndividual(equipment);
		assertEquals(true, found.equals(equipment));
	}

	@Test
	public void testGetNotEmpty() throws IOException {
		Equipment equipment = new Equipment("T", new File("T.png"), "Good");
		equipmentModel.add(equipment);
		
		Equipment equipment2 = new Equipment("T2", new File("T2.png"), "Good");
		equipmentModel.add(equipment2);
		
		assertEquals(2, equipmentModel.get().size());
	}

	@Test
	public void testRemove() throws IOException {
		Equipment equipment = new Equipment("T", new File("T.png"), "Good");
		equipmentModel.add(equipment);
		
		Equipment equipment2 = new Equipment("T2", new File("T2.png"), "Good");
		equipmentModel.add(equipment2);
		
		Equipment equipment3 = new Equipment("T3", new File("T3.png"), "Good");
		equipmentModel.add(equipment3);
		
		equipmentModel.remove(equipment2);
		assertEquals(null, equipmentModel.getIndividual(equipment2));
		assertEquals(true, equipmentModel.getIndividual(equipment).equals(equipment));
	}
}
