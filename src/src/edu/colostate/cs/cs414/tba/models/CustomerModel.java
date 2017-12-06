package edu.colostate.cs.cs414.tba.models;

import java.util.HashSet;
import java.util.Set;

import edu.colostate.cs.cs414.tba.domain.Customer;


/**
 * Handles persistence and retrieval of customers
 */
public class CustomerModel implements Model<Customer> {
	private Set<Customer> customers = new HashSet<Customer>();
	private static CustomerModel model;
	
	private CustomerModel() {}
	public static CustomerModel getInstance() {
		if (model == null) {
			model = new CustomerModel();
		}
		
		return model;
	}
	
	@Override
	public Customer getIndividual(Customer item) {
		for (Customer customer : customers) {
			if (customer.equals(item)) {
				return customer;
			}
		}
		
		return null;
	}

	@Override
	public Set<Customer> get() {
		return customers;
	}

	@Override
	public void add(Customer item) {
		customers.add(item);
	}

	@Override
	public void remove(Customer item) {
		customers.remove(item);
	}

}
