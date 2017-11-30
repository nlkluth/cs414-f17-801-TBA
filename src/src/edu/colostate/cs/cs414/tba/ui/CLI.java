package edu.colostate.cs.cs414.tba.ui;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import edu.colostate.cs.cs414.tba.application.ExerciseBuilder;
import edu.colostate.cs.cs414.tba.domain.Customer;
import edu.colostate.cs.cs414.tba.domain.Equipment;
import edu.colostate.cs.cs414.tba.domain.Manager;
import edu.colostate.cs.cs414.tba.domain.Trainer;
import edu.colostate.cs.cs414.tba.domain.WorkoutRoutine;
import edu.colostate.cs.cs414.tba.services.CustomerCreator;
import edu.colostate.cs.cs414.tba.services.GymSystem;
import edu.colostate.cs.cs414.tba.services.TrainerCreator;
import edu.colostate.cs.cs414.tba.services.WorkoutCreator;

/**
 * Simple Command line interface
 */
public class CLI {
	private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	private Manager manager;
	private GymSystem gymSystem;
	private Object user;		
	private static CLI uniqueInstance;	
	private WorkoutCreator workoutCreator = new WorkoutCreator();
	private CustomerCreator customerCreator = new CustomerCreator();
	private TrainerCreator trainerCreator = new TrainerCreator();
	
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
		
		workoutCreator.assignWorkout((Trainer) this.user, this.gymSystem);
	}

	private void searchCustomers() {
		if (this.manager.equals(this.user)) {
			System.out.println("Not Authorized");
			return;
		}
		
		System.out.println("Customers:\n");
		for (Customer customer : gymSystem.getCustomers()) {
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
		for (WorkoutRoutine workoutRoutine : gymSystem.getWorkoutRoutines()) {
			System.out.println(workoutRoutine.toString() + "\n");
		}
	}
	
	private void modifyCustomer() throws IOException {
		if (!this.manager.equals(this.user)) {
			System.out.println("Not Authorized");
			return;
		}
		
		customerCreator.modifyCustomer(this.manager, this.gymSystem);
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
		
		Equipment equipment = new Equipment(name, new File(file), quality);
		manager.addEquipment(equipment);
		System.out.println("\n ***Equipment added to system*** \n");
	}

	private void registerCustomer() throws IOException {
		if (!this.manager.equals(this.user)) {
			System.out.println("Not Authorized");
			return;
		}
		
		customerCreator.registerCustomer(this.manager);
	}

	private void hireTrainer() throws IOException {
		if (!this.manager.equals(this.user)) {
			System.out.println("Not Authorized");
			return;
		}
		
		trainerCreator.createTrainer(this.manager);
	}
	
	private void modifyTrainer() throws IOException {
		if (!this.manager.equals(this.user)) {
			System.out.println("Not Authorized");
			return;
		}
		
		trainerCreator.modifyTrainer(this.manager, this.gymSystem);
	}

	private void modifyEquipment() throws IOException {
		if (!this.manager.equals(this.user)) {
			System.out.println("Not Authorized");
			return;
		}
		
		System.out.println("Enter name of equipment");
		String name = reader.readLine();
		
		for (Equipment equipment : gymSystem.getEquipment()) {
			if (equipment.getName().equals(name)) {
				System.out.println("\nEnter name of equipment");
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
			}
		}
		
		System.out.println("Error: no equipment found with that name");
	}
}
