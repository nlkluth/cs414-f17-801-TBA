package edu.colostate.cs.cs414.tba.application;

import edu.colostate.cs.cs414.tba.domain.Address;
import edu.colostate.cs.cs414.tba.domain.Customer;
import edu.colostate.cs.cs414.tba.domain.Insurance;
import edu.colostate.cs.cs414.tba.domain.Manager;
import edu.colostate.cs.cs414.tba.domain.PersonalInformation;
import edu.colostate.cs.cs414.tba.domain.Trainer;

/**
 * creates a User type
 * Manager | Trainer | Customer
 * these share many traits but have differing permissions/responsibilities
 */
public class UserFactory {
	public User createUser(String type, String username, String password) {
		User user = null;
		
		if (type.equals("customer")) {
			user = (User) new Customer(username, password);
		} else if (type.equals("trainer")) {
			user = (User) new Trainer(username, password);
		} else if (type.equals("manager")) {
			user = (User) new Manager(username, password);
		}
		
		return user;
	}
}
