package edu.colostate.cs.cs414.tba.services;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import edu.colostate.cs.cs414.tba.application.GymSystem;
import edu.colostate.cs.cs414.tba.gymmanagement.Address;
import edu.colostate.cs.cs414.tba.gymmanagement.Customer;
import edu.colostate.cs.cs414.tba.gymmanagement.Equipment;
import edu.colostate.cs.cs414.tba.gymmanagement.Insurance;
import edu.colostate.cs.cs414.tba.gymmanagement.Manager;
import edu.colostate.cs.cs414.tba.gymmanagement.PersonalInformation;
import edu.colostate.cs.cs414.tba.gymmanagement.Trainer;

/**
 * Simple Command line interface
 */
public class CLIController {
	private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	private Manager manager;
	private GymSystem gymSystem;
	private Object user;
	
	public CLIController(Manager manager, GymSystem gymSystem) throws IOException {
		this.manager = manager;
		this.gymSystem = gymSystem;
		System.out.println("Login as manager to start");
		
		String username = "";
		String password = "";
		
		while (!this.manager.getUsername().equals(username) || !this.manager.getPassword().equals(password)) {						
			System.out.print("Username:");
			username = reader.readLine();
			
			System.out.print("Password:");
			password = reader.readLine();
		}
		
		this.user = manager;
		this.inputLoop();
	}
	
	private void promptForLogin() throws IOException {
		String username = "";
		String password = "";
		boolean loggedIn = false;
		
		while (!loggedIn) {					
			System.out.print("Username:");
			username = reader.readLine();
			
			System.out.print("Password:");
			password = reader.readLine();
			
			if (this.manager.getUsername().equals(username) && this.manager.getPassword().equals(password)) {
				this.user = this.manager;
				loggedIn = true;
			} else {
				for (Trainer trainer : gymSystem.getTrainers()) {
					if (trainer.getUsername().equals(username) && trainer.getPassword().equals(password)) {
						this.user = trainer;
						loggedIn = true;
					}
				}
			}			
		}
				
		this.inputLoop();
	}
	
	public void inputLoop() throws IOException {
		System.out.println("***************");
		System.out.println("\n");
		System.out.println("Welcome to Gym Management System");
		System.out.println("Type a command to get started, or type 'help'");
		System.out.println('\n');
		
		while (true) {
			String input = reader.readLine();
			
			switch (input.toLowerCase()) {
			case "help":
				this.printHelp();
				break;
			case "logout":
				this.promptForLogin();
				break;
			case "hiretrainer":
				this.hireTrainer();
				break;
			case "registercustomer":
				this.registerCustomer();
				break;
			case "addequipment":
				this.addEquipment();
				break;
			case "modifytrainer":
				this.modifyTrainer();
				break;
			case "modifycustomer":
				this.modifyCustomer();
				break;
			case "modifyequipment":
				this.modifyEquipment();
				break;
			case "createworkout":
				this.createWorkout();
				break;
			case "searchroutines":
				this.searchRoutines();
				break;
			case "modifyroutine":
				this.modifyRoutine();
				break;
			case "searchcustomers":
				this.searchCustomers();
				break;
			case "assignroutine":
				this.assignRoutine();
				break;
			default:
				System.out.println("Unrecognized command. Type 'help' for help");
			}
		}
	}

	private void modifyEquipment() {
		if (!this.manager.equals(this.user)) {
			System.out.println("Not Authorized");
			return;
		}
	}

	private void modifyTrainer() {
		if (!this.manager.equals(this.user)) {
			System.out.println("Not Authorized");
			return;
		}
	}

	private void assignRoutine() {
		if (this.manager.equals(this.user)) {
			System.out.println("Not Authorized");
			return;
		}
	}

	private void searchCustomers() {
		if (this.manager.equals(this.user)) {
			System.out.println("Not Authorized");
			return;
		}
	}

	private void modifyRoutine() {
		if (this.manager.equals(this.user)) {
			System.out.println("Not Authorized");
			return;
		}
	}

	private void searchRoutines() {
		if (this.manager.equals(this.user)) {
			System.out.println("Not Authorized");
			return;
		}
	}

	private void createWorkout() {
		if (this.manager.equals(this.user)) {
			System.out.println("Not Authorized");
			return;
		}
	}

	private void modifyCustomer() {
		if (!this.manager.equals(this.user)) {
			System.out.println("Not Authorized");
			return;
		}
		
	}

	private void addEquipment() throws IOException {
		if (!this.manager.equals(this.user)) {
			System.out.println("Not Authorized");
			return;
		}
		
		System.out.println("\nEnter name of equipment");
		String name = reader.readLine();
		System.out.println("Enter file path for image");
		String file = reader.readLine();
		System.out.println("Enter quality rating");
		String quality = reader.readLine();
		
		Equipment equipment = new Equipment(name, new File(file), quality);
		manager.addEquipment(equipment);
		System.out.println("\n ***Equipment added to system*** \n");
	}

	private void registerCustomer() throws IOException {
		if (!this.manager.equals(this.user)) {
			System.out.println("Not Authorized");
			return;
		}
		
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
		
		Customer customer = new Customer(personalInformation, address, insurance);
		manager.registerCustomer(customer);
		System.out.println("\n ***Customer added to system*** \n");
	}

	private void hireTrainer() throws IOException {
		if (!this.manager.equals(this.user)) {
			System.out.println("Not Authorized");
			return;
		}
		
		System.out.println("Enter username for trainer: ");
		String username = reader.readLine();
		
		System.out.println("Enter password for trainer: ");
		String password = reader.readLine();
		
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
		
		Trainer trainer = new Trainer(username, password, personalInformation, address, insurance);
		manager.hireTrainer(trainer);
		System.out.println("\n ***Trainer added to system*** \n");
	}

	public void printHelp() {
		String commandsForUser = "";
		
		if (this.manager.equals(this.user)) {
			commandsForUser = "\n"
					+ "hireTrainer - hire a new trainer\n"
					+ "registerCustomer - register a new customer\n"
					+ "addEquipment - add a new equipment to inventory\n"
					+ "modifyTrainer - modify a trainer's information\n"
					+ "modifyCustomer - modify a customer's information\n"
					+ "modifyEquipment - modify an equipment's information";
		} else {
			commandsForUser = "\n"
					+ "createWorkout - create a new workout routine\n"
					+ "searchRoutines - search workout routines\n"
					+ "modifyRoutine - modify a workout routine\n"
					+ "searchCustomers - search customers\n"
					+ "assignRoutine - assign a routine to a customer"; 
		}
		
		System.out.println("Available Commands:\n"
				+ "logout - log out of system"
				+ commandsForUser);
	}
}
