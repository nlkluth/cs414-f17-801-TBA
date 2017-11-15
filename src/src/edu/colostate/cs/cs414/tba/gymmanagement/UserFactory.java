package edu.colostate.cs.cs414.tba.gymmanagement;

import edu.colostate.cs.cs414.tba.domain.Address;
import edu.colostate.cs.cs414.tba.domain.Customer;
import edu.colostate.cs.cs414.tba.domain.Insurance;
import edu.colostate.cs.cs414.tba.domain.PersonalInformation;
import edu.colostate.cs.cs414.tba.domain.Trainer;

/**
 * creates a User type
 * Manager | Trainer | Customer
 * these share many traits but have differing permissions/responsibilities
 */
public class UserFactory {
	public User createUser(String type, String username, String password, PersonalInformation personalInformation, Address address, Insurance insurance) {
		User user = null;
		
		if (type.equals("customer")) {
			user = (User) new Customer(personalInformation, address, insurance);
		} else if (type.equals("trainer")) {
			user = (User) new Trainer(username, password, personalInformation, address, insurance);
		}
		
		return user;
	}
}
