package edu.colostate.cs.cs414.tba.tests;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import edu.colostate.cs.cs414.tba.application.GymSystem;
import edu.colostate.cs.cs414.tba.gymmanagement.Address;
import edu.colostate.cs.cs414.tba.gymmanagement.Customer;
import edu.colostate.cs.cs414.tba.gymmanagement.Equipment;
import edu.colostate.cs.cs414.tba.gymmanagement.Insurance;
import edu.colostate.cs.cs414.tba.gymmanagement.PersonalInformation;
import edu.colostate.cs.cs414.tba.gymmanagement.Trainer;

public class GymSystemTest {
	private GymSystem gymSystem;
	
	@Before public void setUp() {
		gymSystem = new GymSystem();
	}
	
	@Test
	public void testGetCustomers() {
		assertEquals(0, gymSystem.getCustomers().size());
	}
	
	@Test
	public void testAddCustomer() {
		Customer customer = new Customer(
				new PersonalInformation("Nathan", "Kluth", "444-444-4444", "test@example.com"),
				new Address("123", "4", "Denver", "CO", "80231"),
				new Insurance("Blue Cross", new Address("123", "4", "Denver", "CO", "80231"))
				);
		
		gymSystem.addCustomer(customer);
		assertEquals(true, customer.equals((Customer) gymSystem.getCustomers().toArray()[0]));
	}
	
	@Test
	public void testGetTrainers() {
		assertEquals(0, gymSystem.getTrainers().size());
	}
	
	@Test
	public void testAddTrainer() {
		Trainer trainer = new Trainer("username", "Password",
				new PersonalInformation("Nathan", "Kluth", "444-444-4444", "test@example.com"),
				new Address("123", "4", "Denver", "CO", "80231"),
				new Insurance("Blue Cross", new Address("123", "4", "Denver", "CO", "80231"))
				);
		
		gymSystem.addTrainer(trainer);
		assertEquals(true, trainer.equals(gymSystem.getTrainers().toArray()[0]));
	}
	
	@Test
	public void testGetEquipment() {
		assertEquals(0, gymSystem.getEquipment().size());
	}
	
	@Test
	public void testAddEquipment() {
		Equipment equipment = new Equipment("Free weights", new File("./weights.png"), "Excellent");
		
		gymSystem.addEquipment(equipment);
		assertEquals(equipment, gymSystem.getEquipment().toArray()[0]);
	}
}
