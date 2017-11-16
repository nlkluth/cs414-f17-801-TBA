package edu.colostate.cs.cs414.tba.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import edu.colostate.cs.cs414.tba.application.GymSystem;
import edu.colostate.cs.cs414.tba.domain.Address;
import edu.colostate.cs.cs414.tba.domain.Customer;
import edu.colostate.cs.cs414.tba.domain.Insurance;
import edu.colostate.cs.cs414.tba.domain.Manager;
import edu.colostate.cs.cs414.tba.domain.PersonalInformation;
import edu.colostate.cs.cs414.tba.gymmanagement.UserFactory;

public class CustomerCreator {
	private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	private UserFactory userFactory = new UserFactory();
	
	public void registerCustomer(Manager manager) throws IOException {
		System.out.println("\nEnter Personal Information");
		System.out.println("Name:");
		String name = reader.readLine();
		System.out.println("Last Name:");
		String lastName = reader.readLine();
		System.out.println("Phone:");
		String phone = reader.readLine();
		System.out.println("email:");
		String email = reader.readLine();
		PersonalInformation personalInformation = new PersonalInformation(name, lastName, phone, email);
		
		System.out.println("\nEnter Address information");
		System.out.println("Street");
		String street = reader.readLine();
		System.out.println("Street 2");
		String street2 = reader.readLine();
		System.out.println("City");
		String city = reader.readLine();
		System.out.println("State");
		String state = reader.readLine();
		System.out.println("Zip");
		String zip = reader.readLine();
		Address address = new Address(street, street2, city, state, zip);
		
		System.out.println("\nEnter insurance information");
		System.out.println("Insurance name");
		String insuranceName = reader.readLine();
		System.out.println("Insurance street");
		String insuranceStreet = reader.readLine();
		System.out.println("Insurance street 2");
		String insuranceStreet2 = reader.readLine();
		System.out.println("Insurance city");
		String insuranceCity = reader.readLine();
		System.out.println("Insurance state");
		String insuranceState = reader.readLine();
		System.out.println("Insurance zip");
		String insuranceZip = reader.readLine();
		Address insuranceAddress = new Address(insuranceStreet, insuranceStreet2, insuranceCity, insuranceState, insuranceZip);
		Insurance insurance = new Insurance(insuranceName, insuranceAddress);
		
		Customer customer = (Customer) userFactory.createUser("customer", null, null, personalInformation, address, insurance);
		manager.registerCustomer(customer);
		System.out.println("\n ***Customer added to system*** \n");
	}

	public void modifyCustomer(Manager manager, GymSystem gymSystem) throws IOException {
		System.out.println("Enter customer first name");
		String name = reader.readLine();
		System.out.println("Enter customer last name");
		String lastName = reader.readLine();
		
		for (Customer customer : gymSystem.getCustomers()) {
			if (customer.getPersonalInformation().getName().equals(name + " " + lastName)) {
				System.out.println("Customer found");
				System.out.println("\nEnter Personal Information");
				System.out.println("Name:");
				String newName = reader.readLine();
				System.out.println("Last Name:");
				String newLast = reader.readLine();
				System.out.println("Phone:");
				String phone = reader.readLine();
				System.out.println("email:");
				String email = reader.readLine();
				PersonalInformation personalInformation = new PersonalInformation(newName, newLast, phone, email);
				
				System.out.println("\nEnter Address information");
				System.out.println("Street");
				String street = reader.readLine();
				System.out.println("Street 2");
				String street2 = reader.readLine();
				System.out.println("City");
				String city = reader.readLine();
				System.out.println("State");
				String state = reader.readLine();
				System.out.println("Zip");
				String zip = reader.readLine();
				Address address = new Address(street, street2, city, state, zip);
				
				System.out.println("\nEnter insurance information");
				System.out.println("Insurance name");
				String insuranceName = reader.readLine();
				System.out.println("Insurance street");
				String insuranceStreet = reader.readLine();
				System.out.println("Insurance street 2");
				String insuranceStreet2 = reader.readLine();
				System.out.println("Insurance city");
				String insuranceCity = reader.readLine();
				System.out.println("Insurance state");
				String insuranceState = reader.readLine();
				System.out.println("Insurance zip");
				String insuranceZip = reader.readLine();
				Address insuranceAddress = new Address(insuranceStreet, insuranceStreet2, insuranceCity, insuranceState, insuranceZip);
				Insurance insurance = new Insurance(insuranceName, insuranceAddress);
				
				customer.update(personalInformation, address, insurance);
				System.out.println("\n *** Customer updated in the system *** \n");
				return;
			}
		}
		
		System.out.println("Error: no customer found with that name");
	}

}
