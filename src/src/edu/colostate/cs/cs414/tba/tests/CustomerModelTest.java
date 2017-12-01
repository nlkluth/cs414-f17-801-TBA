package edu.colostate.cs.cs414.tba.tests;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import edu.colostate.cs.cs414.tba.domain.Customer;
import edu.colostate.cs.cs414.tba.domain.PersonalInformation;
import edu.colostate.cs.cs414.tba.models.CustomerModel;

public class CustomerModelTest {
	private CustomerModel customerModel;
	
	@Before public void setUp() {
		customerModel = CustomerModel.getInstance();
	}
	  
	@Test
	public void testGetEmpty() throws IOException {
		Set<Customer> emptySet = new HashSet<Customer>();
		Set<Customer> set = customerModel.get();
		assertEquals(true, emptySet.equals(set));
	}

	@Test
	public void testGetItemEmpty() throws IOException {
		// returns a null if item isn't found
		Customer customer = new Customer(new PersonalInformation("Testing", "User", null, null), null, null);
		assertEquals(null, customerModel.getIndividual(customer));
	}

	@Test
	public void testAddItem() throws IOException {
		Customer customer = new Customer(new PersonalInformation("Test", "User", null, null), null, null);
		customerModel.add(customer);
		assertEquals(1, customerModel.get().size());
	}

	@Test
	public void testGetItem() throws IOException {
		Customer customer = new Customer(new PersonalInformation("Test", "User", null, null), null, null);;
		customerModel.add(customer);
		Customer found = customerModel.getIndividual(customer);
		assertEquals(true, found.equals(customer));
	}

	@Test
	public void testGetNotEmpty() throws IOException {
		Customer customer = new Customer(new PersonalInformation("Test", "User", null, null), null, null);
		customerModel.add(customer);
		
		Customer customer2 = new Customer(new PersonalInformation("Test2", "User2", null, null), null, null);
		customerModel.add(customer2);
		
		assertEquals(2, customerModel.get().size());		
	}

	@Test
	public void testRemove() throws IOException {
		Customer customer = new Customer(new PersonalInformation("Test", "User", null, null), null, null);
		customerModel.add(customer);
		
		Customer customer2 = new Customer(new PersonalInformation("Test2", "User2", null, null), null, null);
		customerModel.add(customer2);
		
		Customer customer3 = new Customer(new PersonalInformation("Tes3t", "Use3r", null, null), null, null);
		customerModel.add(customer3);
		
		customerModel.remove(customer2);
		assertEquals(null, customerModel.getIndividual(customer2));
		assertEquals(true, customerModel.getIndividual(customer).equals(customer));
	}
}
