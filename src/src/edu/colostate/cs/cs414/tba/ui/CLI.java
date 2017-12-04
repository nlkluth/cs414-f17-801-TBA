package edu.colostate.cs.cs414.tba.ui;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import edu.colostate.cs.cs414.tba.application.Availability;
import edu.colostate.cs.cs414.tba.application.Membership;
import edu.colostate.cs.cs414.tba.application.User;
import edu.colostate.cs.cs414.tba.application.UserFactory;
import edu.colostate.cs.cs414.tba.controllers.CustomerController;
import edu.colostate.cs.cs414.tba.controllers.EquipmentController;
import edu.colostate.cs.cs414.tba.controllers.QualificationController;
import edu.colostate.cs.cs414.tba.controllers.TrainerController;
import edu.colostate.cs.cs414.tba.controllers.WorkoutRoutineController;
import edu.colostate.cs.cs414.tba.domain.Address;
import edu.colostate.cs.cs414.tba.domain.Customer;
import edu.colostate.cs.cs414.tba.domain.Equipment;
import edu.colostate.cs.cs414.tba.domain.Insurance;
import edu.colostate.cs.cs414.tba.domain.Manager;
import edu.colostate.cs.cs414.tba.domain.PersonalInformation;
import edu.colostate.cs.cs414.tba.domain.Qualification;
import edu.colostate.cs.cs414.tba.domain.Trainer;
import edu.colostate.cs.cs414.tba.domain.WorkoutRoutine;
import edu.colostate.cs.cs414.tba.services.GymSystem;

/**
 * Simple Command line interface
 */
public class CLI {
	private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	private TrainerController trainerController = new TrainerController();
	private CustomerController customerController = new CustomerController();
	private EquipmentController equipmentController = new EquipmentController();
	private WorkoutRoutineController workoutRoutineController = new WorkoutRoutineController();
	private QualificationController qualificationController = new QualificationController();
	private UserFactory userFactory = new UserFactory();
	private Manager manager;
	private GymSystem gymSystem;
	private Object user;		
	private static CLI uniqueInstance;	
	private WorkoutCreator workoutCreator = new WorkoutCreator();

	private CLI() {}
	
	public static CLI getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new CLI();		
		}
		
		return uniqueInstance;
	}
	
	public void setManager(Manager manager) {
		this.manager = manager;
	}
	
	public void setGymSystem(GymSystem gymSystem) {
		this.gymSystem = gymSystem;
	}
	
	public void start() throws IOException {
		trainerController = new TrainerController();
		
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
				for (Trainer trainer : trainerController.getAll()) {
					if (trainer.getUsername().equals(username) && trainer.getPassword().equals(password)) {
						this.user = trainer;
						loggedIn = true;
					}
				}
			}			
		}
				
		this.inputLoop();
	}
	
	private void inputLoop() throws IOException {
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
			default:
				System.out.println("Command not found");
			}
		}
	}

	private void printHelp() {
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
	
	// 
	// Helper methods for capturing input from user
	//
	private PersonalInformation capturePersonalInformation() throws IOException {
		System.out.println("\nEnter Personal Information");
		System.out.println("Name:");
		String newName = reader.readLine();
		System.out.println("Last Name:");
		String newLast = reader.readLine();
		System.out.println("Phone:");
		String phone = reader.readLine();
		System.out.println("email:");
		String email = reader.readLine();
		return new PersonalInformation(newName, newLast, phone, email);
	}
	
	private Address captureAddress() throws IOException {
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
		return new Address(street, street2, city, state, zip);		
	}
	
	public Insurance captureInsurance() throws IOException {
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
		return new Insurance(insuranceName, insuranceAddress);
	}
	
	/**
	 * Creates a user via the UserFactory class, user is abstract class inherited by all user types in system
	 * @param type - the type of user to create trainer | manager | customer
	 * @return User, the user Created, cast to Type to use
	 * @throws IOException
	 */
	private User captureUserInfo(String type) throws IOException {
		System.out.println("\nEnter "+ type + " username");
		String username = reader.readLine();
		if (username == null) {
			username = "";
		}
		
		System.out.println("\nEnter " + type + " password");
		String password = reader.readLine();
		if (password == null) {
			password = "";
		}
		
		User user = userFactory.createUser(type, username, password);
		user.setPersonalInformation(this.capturePersonalInformation());
		user.setAddress(this.captureAddress());
		user.setInsurance(this.captureInsurance());
		
		return user;
	}
	
	/**
	 * Method for capturing information about trainer availability
	 * @param trainer - the trainer to assign availability to
	 * @throws IOException
	 */
	private void captureAvailability(Trainer trainer) throws IOException {
		System.out.println("What is the availability for this trainer?");
		System.out.println("(Full time, Part time, seasonal, seasonal part time, unavailable)");
		switch (reader.readLine().toLowerCase()) {
		case "full time":
		case "fulltime":
			trainer.setAvailability(Availability.FULLTIME);
			break;
		case "part time":
		case "parttime":
			trainer.setAvailability(Availability.PARTTIME);
			break;
		case "seasonal":
			trainer.setAvailability(Availability.SEASONAL_FULLTIME);
			break;
		case "seasonal part time":
		case "seasonal parttime":
			trainer.setAvailability(Availability.SEASONAL_PARTTIME);
		default:
			trainer.setAvailability(Availability.UNAVAILABLE);
		}
	}
	
	/**
	 * Method for capturing information about trainer qualifications
	 * @param trianer - the trainer to assign qualifications to
	 * @throws IOException
	 */
	private void captureQualifications(Trainer trainer) throws IOException {
		System.out.println("What qualificaitons does this trainer have? (comma separated)");
		String[] qualifications = reader.readLine().split(",");
		for (String qualification : qualifications) {
			Qualification q = qualificationController.create(qualification, trainer);
			trainer.addQualification(q);
			
		}
	}
	
	// 
	// End Helper methods for capturing input from user
	//
	
	private void createWorkout() throws IOException {
		if (this.manager.equals(this.user)) {
			System.out.println("Not Authorized");
			return;
		}
		
		workoutCreator.createWorkout((Trainer) this.user, this.gymSystem);
	}


	private void assignRoutine() throws IOException {
		if (this.manager.equals(this.user)) {
			System.out.println("Not Authorized");
			return;
		}
		
		workoutCreator.assignWorkout();
	}

	private void searchCustomers() {
		if (this.manager.equals(this.user)) {
			System.out.println("Not Authorized");
			return;
		}
		
		System.out.println("Customers:\n");
		for (Customer customer : customerController.getAll()) {
			System.out.println(customer.toString() + "\n");
		}
	}

	private void modifyRoutine() throws IOException {
		if (this.manager.equals(this.user)) {
			System.out.println("Not Authorized");
			return;
		}
		
		workoutCreator.modifyRoutine((Trainer) this.user, this.gymSystem);
	}
	
	private void searchRoutines() {
		if (this.manager.equals(this.user)) {
			System.out.println("Not Authorized");
			return;
		}
		
		System.out.println("Workout Routines:\n");
		for (WorkoutRoutine workoutRoutine : workoutRoutineController.getAll()) {
			System.out.println(workoutRoutine.toString() + "\n");
		}
	}
	
	private void modifyCustomer() throws IOException {
		if (!this.manager.equals(this.user)) {
			System.out.println("Not Authorized");
			return;
		}
		
		System.out.println("Enter customer first name");
		String name = reader.readLine();
		System.out.println("Enter customer last name");
		String lastName = reader.readLine();
		
		for (Customer customer : customerController.getAll()) {
            if (customer.getPersonalInformation().getName().equals(name + " " + lastName)) {
            	customer.setPersonalInformation(this.capturePersonalInformation());
            	customer.setAddress(this.captureAddress());
            	customer.setInsurance(this.captureInsurance());
            	System.out.println("\n *** Customer updated in system *** \n");
            	return;
            }
		}
		
		System.out.println("Error: no customer found with that name");
	}

	private void addEquipment() throws IOException {
		if (!this.manager.equals(this.user)) {
			System.out.println("Not Authorized");
			return;
		}
		
		System.out.println("\nEnter name of equipment");
		String name = reader.readLine();
		if (name == null) {
			name = "";
		}
		
		System.out.println("Enter file path for image");
		String file = reader.readLine();
		if (file == null) {
			file = "";
		}
		
		System.out.println("Enter quality rating");
		String quality = reader.readLine();
		if (quality == null) {
			quality = "";
		}
		
		equipmentController.create(name, new File(file), quality);
		System.out.println("\n ***Equipment added to system*** \n");
	}

	private void registerCustomer() throws IOException {
		if (!this.manager.equals(this.user)) {
			System.out.println("Not Authorized");
			return;
		}
		
		Customer customer = (Customer) this.captureUserInfo("customer");
		System.out.println("Is customer active? (Y / N)");
		String YN = reader.readLine();
		if (YN == null) {
			YN = "Y";
		}
		
		if (YN.toUpperCase() == "N") {
			customer.setActive(Membership.INACTIVE);
		}
		
		customerController.create(customer);		
		System.out.println("\n *** Customer added to system *** \n");
	}

	private void hireTrainer() throws IOException {
		if (!this.manager.equals(this.user)) {
			System.out.println("Not Authorized");
			return;
		}
		
		Trainer trainer = (Trainer) this.captureUserInfo("trainer");
		this.captureAvailability(trainer);
		this.captureQualifications(trainer);
		
		trainerController.create(trainer);
		System.out.println("\n *** Trainer added to system *** \n");
	}
	
	private void modifyTrainer() throws IOException {
		if (!this.manager.equals(this.user)) {
			System.out.println("Not Authorized");
			return;
		}
		
		System.out.println("Enter trainer first name");
		String name = reader.readLine();
		System.out.println("Enter trainer last name");
		String lastName = reader.readLine();
		
		for (Trainer trainer : trainerController.getAll()) {
            if (trainer.getPersonalInformation().getName().equals(name + " " + lastName)) {
            	trainer.setPersonalInformation(this.capturePersonalInformation());
            	trainer.setAddress(this.captureAddress());
            	trainer.setInsurance(this.captureInsurance());
            	System.out.println("\n *** Trainer modified in system *** \n");
            	return;
            }
		}
		
		System.out.println("Error: no trainer found with that name");
	}

	private void modifyEquipment() throws IOException {
		if (!this.manager.equals(this.user)) {
			System.out.println("Not Authorized");
			return;
		}
		
		System.out.println("Enter name of equipment");
		String name = reader.readLine();
		
		for (Equipment equipment : equipmentController.getAll()) {		
			if (equipment.getName().equals(name)) {
				System.out.println("\nEnter new name of equipment");
				String newName = reader.readLine();
				if (newName == null) {
					newName = "";
				}
				
				System.out.println("Enter file path for image");
				String file = reader.readLine();
				if (file == null) {
					file = "";
				}
				
				System.out.println("Enter quality rating");
				String quality = reader.readLine();
				if (quality== null) {
					quality = "";
				}
				
				equipment.update(newName, new File(file), quality);				
				System.out.println("\n ***Equipment updated in system*** \n");
				return;
			}
		}
		
		System.out.println("Error: no equipment found with that name");
	}
}
