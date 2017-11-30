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
import edu.colostate.cs.cs414.tba.domain.Manager;
import edu.colostate.cs.cs414.tba.domain.PersonalInformation;
import edu.colostate.cs.cs414.tba.domain.Trainer;
import edu.colostate.cs.cs414.tba.services.GymSystem;

public class ManagerTest {
	private Manager manager;
	private GymSystem gymSystem = new GymSystem();
	
	@Before public void setUp() {
		manager = new Manager("Admin", "Password", gymSystem);
	}
	
	@Test
	public void testGetPersonalInformation() throws IOException {
		assertEquals(null, manager.getPersonalInformation());
	}
	
	@Test
	public void testGetInsurance() throws IOException {
		assertEquals(null, manager.getInsurance());
	}
	
	@Test
	public void testGetAddress() throws IOException {
		assertEquals(null, manager.getAddress());
	}
	
	@Test
	public void setPersonalInformation() throws IOException {
		manager.setPersonalInformation(new PersonalInformation("Nathan",
				"Kluth", "444-444-4444", "test@example.com"));
		assertEquals("User: Nathan Kluth\nphone: 444-444-4444\nemail: test@example.com", manager.getPersonalInformation().toString());
	}
	
	@Test
	public void testSetInsurance() throws IOException {
		manager.setInsurance(new Insurance("Blue Cross", new Address("123",
				"4", "Denver", "CO", "80231")));
		
		assertEquals("Blue Cross:\n123 4, Denver CO, 80231", manager.getInsurance().toString());
	}
	
	@Test
	public void testSetAddress() throws IOException {
		manager.setAddress(new Address("123", "4", "Denver", "CO", "80231"));
		assertEquals("123 4, Denver CO, 80231", manager.getAddress().toString());
	}
	
	@Test
	public void testRegisterCustomer() throws IOException {
		Customer customer = new Customer(
				new PersonalInformation("Nathan", "Kluth", "444-444-4444", "test@example.com"),
				new Address("123", "4", "Denver", "CO", "80231"),
				new Insurance("Blue Cross", new Address("123", "4", "Denver", "CO", "80231"))
				);
		
		manager.registerCustomer(customer);
		assertEquals(1, gymSystem.getCustomers().size());
	}
	
	@Test
	public void testHireTrainer() throws IOException {
		Trainer trainer = new Trainer("user", "Password",
				new PersonalInformation("Nathan", "Kluth", "444-444-4444", "test@example.com"),
				new Address("123", "4", "Denver", "CO", "80231"),
				new Insurance("Blue Cross", new Address("123", "4", "Denver", "CO", "80231"))
				);
		
		manager.hireTrainer(trainer);
		assertEquals(1, gymSystem.getTrainers().size());
	}
	
	@Test
	public void testAddEquipment() throws IOException {
		Equipment equipment = new Equipment("Free weights", new File("./weights.png"), "Excellent");
		
		manager.addEquipment(equipment);
		assertEquals(1, gymSystem.getEquipment().size());
	}
}
