package edu.colostate.cs.cs414.tba.tests;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import edu.colostate.cs.cs414.tba.domain.Address;
import edu.colostate.cs.cs414.tba.domain.Customer;
import edu.colostate.cs.cs414.tba.domain.Equipment;
import edu.colostate.cs.cs414.tba.domain.Insurance;
import edu.colostate.cs.cs414.tba.domain.PersonalInformation;
import edu.colostate.cs.cs414.tba.domain.Trainer;
import edu.colostate.cs.cs414.tba.services.GymSystem;

public class GymSystemTest {
	private GymSystem gymSystem;
	
	@Before public void setUp() {
		gymSystem = new GymSystem();
	}
	
	@Test
	public void testGetCustomers() throws IOException {
		assertEquals(0, gymSystem.getCustomers().size());
	}
	
	@Test
	public void testAddCustomer() throws IOException {
		Customer customer = new Customer("username", "pass");
		
		gymSystem.addCustomer(customer);
		assertEquals(true, customer.equals((Customer) gymSystem.getCustomers().toArray()[0]));
	}
	
	@Test
	public void testGetTrainers() throws IOException {
		assertEquals(0, gymSystem.getTrainers().size());
	}
	
	@Test
	public void testAddTrainer() throws IOException {
		Trainer trainer = new Trainer("username", "Password");
		gymSystem.addTrainer(trainer);
		assertEquals(true, trainer.equals(gymSystem.getTrainers().toArray()[0]));
	}
	
	@Test
	public void testGetEquipment() throws IOException {
		assertEquals(0, gymSystem.getEquipment().size());
	}
	
	@Test
	public void testAddEquipment() throws IOException {
		Equipment equipment = new Equipment("Free weights", new File("./weights.png"), "Excellent");
		
		gymSystem.addEquipment(equipment);
		assertEquals(equipment, gymSystem.getEquipment().toArray()[0]);
	}
}
