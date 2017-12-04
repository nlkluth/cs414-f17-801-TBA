package edu.colostate.cs.cs414.tba.tests;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import edu.colostate.cs.cs414.tba.controllers.CustomerController;
import edu.colostate.cs.cs414.tba.domain.Customer;
import edu.colostate.cs.cs414.tba.domain.Exercise;
import edu.colostate.cs.cs414.tba.domain.PersonalInformation;

public class CustomerControllerTest {
	private CustomerController controller;
	
	@Before public void setUp() {
		controller = new CustomerController();
		// clear out any customers to get back to empty
		for (Customer customer : controller.getAll()) {
			controller.delete(customer);
		}
	}
	
	@Test
	public void testGetAllEmpty() throws IOException {
		Set<Customer> customerSet = new HashSet<Customer>();
		Set<Customer> found = controller.getAll();
		assertEquals(true, found.equals(customerSet));
	}
	
	@Test
	public void testCreate() throws IOException {
		controller.create("username", "password");
		assertEquals(1, controller.getAll().size());
	}
	
	@Test
	public void testGetById() throws IOException {
		Customer customer = controller.create("username", "password");
		Customer found = controller.get(customer.getId());
		assertEquals(true, found.equals(customer));
	}
	
	@Test
	public void testGetByObject() throws IOException {
		Customer customer = controller.create("username", "password");
		Customer found = controller.get(customer);
		assertEquals(true, found.equals(customer));
	}
	
	@Test
	public void testGetAll() throws IOException {
		controller.create("username", "password");
		assertEquals(1, controller.getAll().size());
	}
	
	@Test
	public void testDeleteBObject() throws IOException {
		Customer customer = controller.create("username", "password");
		controller.delete(customer);
		Customer found = controller.get(customer);
		assertEquals(null, found);
	}
}
