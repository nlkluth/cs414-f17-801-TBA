package edu.colostate.cs.cs414.tba.controllers;

import java.rmi.server.UID;
import java.util.Set;

import edu.colostate.cs.cs414.tba.domain.Customer;
import edu.colostate.cs.cs414.tba.models.CustomerModel;

/**
 * Manages Customer domain and ComsterModel classes
 */
public class CustomerController implements Controller<Customer> {
	private CustomerModel model;
	
	public CustomerController() {
		model = CustomerModel.getInstance();
	}
	
	public Customer create(String username, String password) {
		Customer customer = new Customer(username, password);
		model.add(customer);
		return customer;
	}

	@Override
	public Set<Customer> getAll() {
		return model.get();
	}

	@Override
	public Customer get(UID id) {
		for (Customer customer : model.get()) {
			if (customer.getId() == id) {
				return customer;
			}
		}
		
		return null;
	}

	@Override
	public Customer get(Customer item) {
		return model.getIndividual(item);
	}

	@Override
	public void delete(Customer item) {
		model.remove(item);
	}

	/**
	 * Used by factory to add customer after object was created
	 */
	public void create(Customer customer) {
		model.add(customer);
	}
	

}
