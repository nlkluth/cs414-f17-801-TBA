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
import edu.colostate.cs.cs414.tba.gymmanagement.Manager;
import edu.colostate.cs.cs414.tba.gymmanagement.PersonalInformation;
import edu.colostate.cs.cs414.tba.gymmanagement.Trainer;

public class ManagerTest {
	private Manager manager;
	private GymSystem gymSystem = new GymSystem();
	
	@Before public void setUp() {
		manager = new Manager("Admin", "Password", gymSystem);
	}
	
	@Test
	public void testGetPersonalInformation() {
		assertEquals(null, manager.getPersonalInformation());
	}
	
	@Test
	public void testGetInsurance() {
		assertEquals(null, manager.getInsurance());
	}
	
	@Test
	public void testGetAddress() {
		assertEquals(null, manager.getAddress());
	}
	
	@Test
	public void setPersonalInformation() {
		manager.setPersonalInformation(new PersonalInformation("Nathan",
				"Kluth", "444-444-4444", "test@example.com"));
		assertEquals("User: Nathan Kluth\nphone: 444-444-4444\nemail: test@example.com", manager.getPersonalInformation().toString());
	}
	
	@Test
	public void testSetInsurance() {
		manager.setInsurance(new Insurance("Blue Cross", new Address("123",
				"4", "Denver", "CO", "80231")));
		
		assertEquals("Blue Cross:\n123 4, Denver CO, 80231", manager.getInsurance().toString());
	}
	
	@Test
	public void testSetAddress() {
		manager.setAddress(new Address("123", "4", "Denver", "CO", "80231"));
		assertEquals("123 4, Denver CO, 80231", manager.getAddress().toString());
	}
	
	@Test
	public void testRegisterCustomer() {
		Customer customer = new Customer(
				new PersonalInformation("Nathan", "Kluth", "444-444-4444", "test@example.com"),
				new Address("123", "4", "Denver", "CO", "80231"),
				new Insurance("Blue Cross", new Address("123", "4", "Denver", "CO", "80231"))
				);
		
		manager.registerCustomer(customer);
		assertEquals(1, gymSystem.getCustomers().size());
	}
	
	@Test
	public void testHireTrainer() {
		Trainer trainer = new Trainer("user", "Password",
				new PersonalInformation("Nathan", "Kluth", "444-444-4444", "test@example.com"),
				new Address("123", "4", "Denver", "CO", "80231"),
				new Insurance("Blue Cross", new Address("123", "4", "Denver", "CO", "80231"))
				);
		
		manager.hireTrainer(trainer);
		assertEquals(1, gymSystem.getTrainers().size());
	}
	
	@Test
	public void testAddEquipment() {
		Equipment equipment = new Equipment("Free weights", new File("./weights.png"), "Excellent");
		
		manager.addEquipment(equipment);
		assertEquals(1, gymSystem.getEquipment().size());
	}
}
