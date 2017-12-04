package edu.colostate.cs.cs414.tba.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import edu.colostate.cs.cs414.tba.application.UserFactory;
import edu.colostate.cs.cs414.tba.domain.Address;
import edu.colostate.cs.cs414.tba.domain.Insurance;
import edu.colostate.cs.cs414.tba.domain.Manager;
import edu.colostate.cs.cs414.tba.domain.PersonalInformation;
import edu.colostate.cs.cs414.tba.domain.Trainer;
import edu.colostate.cs.cs414.tba.services.GymSystem;
import edu.colostate.cs.cs414.tba.services.TrainerInfo;

public class TrainerCreator {
	private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	private UserFactory userFactory = new UserFactory();
	
	public void createTrainer(Manager manager) throws IOException {
		System.out.println("Enter username for trainer: ");
		String username = reader.readLine();
		
		System.out.println("Enter password for trainer: ");
		String password = reader.readLine();
		
		System.out.println("\nEnter Personal Information");
		
		TrainerInfo trainerInfo = createTrainer();
		Trainer trainer = (Trainer) userFactory.createUser("trainer", username, password, trainerInfo.getPersonalInformation(), trainerInfo.getAddress(), trainerInfo.getInsurance());
		manager.hireTrainer(trainer);
		System.out.println("\n ***Trainer added to system*** \n");		
	}

	public void modifyTrainer(Manager manager, GymSystem gymSystem) throws IOException {
		System.out.println("Enter trainer first name");
		String name = reader.readLine();
		System.out.println("Enter trainer last name");
		String lastName = reader.readLine();
		
		for (Trainer trainer : gymSystem.getTrainers()) {
			if (trainer.getPersonalInformation().getName().equals(name + " " + lastName)) {
				System.out.println("Trainer found");
				
				TrainerInfo trainerInfo = createTrainer();
				trainer.update(trainerInfo.getPersonalInformation(), trainerInfo.getAddress(), trainerInfo.getInsurance());
				System.out.println("\n *** Trainer updated in the system *** \n");
				return;
			}
		}
		
		System.out.println("Error: no trainer found with that name");
	}

	private TrainerInfo createTrainer() throws IOException {		
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
		return new TrainerInfo(personalInformation, insurance, address);
	}
}
