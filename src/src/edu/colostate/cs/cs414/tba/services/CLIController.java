package edu.colostate.cs.cs414.tba.services;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import edu.colostate.cs.cs414.tba.application.GymSystem;
import edu.colostate.cs.cs414.tba.domain.Address;
import edu.colostate.cs.cs414.tba.domain.Customer;
import edu.colostate.cs.cs414.tba.domain.Equipment;
import edu.colostate.cs.cs414.tba.domain.Exercise;
import edu.colostate.cs.cs414.tba.domain.Insurance;
import edu.colostate.cs.cs414.tba.domain.Manager;
import edu.colostate.cs.cs414.tba.domain.PersonalInformation;
import edu.colostate.cs.cs414.tba.domain.Trainer;
import edu.colostate.cs.cs414.tba.domain.WorkoutRoutine;
import edu.colostate.cs.cs414.tba.gymmanagement.ExerciseBuilder;
import edu.colostate.cs.cs414.tba.gymmanagement.UserFactory;

/**
 * Simple Command line interface
 */
public class CLIController {
	private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	private Manager manager;
	private GymSystem gymSystem;
	private Object user;
	private CustomerCreator customerCreator;	
	private ExerciseBuilder exerciseBuilder;
	private static CLIController uniqueInstance;
	private TrainerCreator trainerCreator;
	
	private CLIController() {}
	
	public static CLIController getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new CLIController();		
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

	private void modifyEquipment() throws IOException {
		if (!this.manager.equals(this.user)) {
			System.out.println("Not Authorized");
			return;
		}
		
		System.out.println("Enter name of equipment");
		String name = reader.readLine();
		
		for (Equipment equipment : gymSystem.getEquipment()) {
			if (equipment.equals(name)) {
				System.out.println("\nEnter name of equipment");
				String newName = reader.readLine();
				System.out.println("Enter file path for image");
				String file = reader.readLine();
				System.out.println("Enter quality rating");
				String quality = reader.readLine();
				
				equipment.update(newName, new File(file), quality);				
				System.out.println("\n ***Equipment updated in system*** \n");
			}
		}
		
		System.out.println("Error: no equipment found with that name");
	}

	private void modifyTrainer() throws IOException {
		if (!this.manager.equals(this.user)) {
			System.out.println("Not Authorized");
			return;
		}
		
		trainerCreator.modifyTrainer(this.manager, this.gymSystem);
	}

	private void assignRoutine() throws IOException {
		if (this.manager.equals(this.user)) {
			System.out.println("Not Authorized");
			return;
		}
		
		Customer customer = null;
		WorkoutRoutine workout = null;
		
		while (user == null) {
			System.out.println("What is the customer firstName?");
			String name = reader.readLine();
			System.out.println("What is the customer lastName?");
			String lastName = reader.readLine();
			
			for (Customer foundCustomer : gymSystem.getCustomers()) {
				if (foundCustomer.getPersonalInformation().getName().toLowerCase().equals(name + " " + lastName)) {
					customer = foundCustomer;
					break;
				}
			}
			
			System.out.println("User not found");
		}
		
		while (workout == null) {
			System.out.println("What workout would you like to assign?");
			String workoutName = reader.readLine();
			
			for (WorkoutRoutine foundWorkout : gymSystem.getWorkoutRoutines()) {
				if (foundWorkout.getName().toString().equals(workoutName)) {
					workout = foundWorkout;
					break;
				}
			}
			
			System.out.println("WorkoutRoutine not found");
		}
		
		workout.assignCustomer(customer);
		customer.addWorkoutRoutine(workout);
		
		System.out.println("\n *** Assigned customer to workout routine *** \n");
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
		
		System.out.println("Enter name of routine: ");
		String name = reader.readLine();
		
		for (WorkoutRoutine workoutRoutine : gymSystem.getWorkoutRoutines()) {
			if (workoutRoutine.getName().equals(name)) {
				System.out.println("Are there changes to exercises? (y/n)");
				String response = reader.readLine();
				
				if (response.toLowerCase().equals("n")) {
					System.out.println("Nothing to change");
					return;
				}
				
				workoutRoutine.resetExercises(); // reset exercises
			
				exerciseBuilder = new ExerciseBuilder();
				boolean addingExercises = true;
				while (addingExercises) {					
					System.out.println("Enter exercise name: ");
					String exerciseName = reader.readLine();
					System.out.println("Enter duration of workout: ");
					String duration = reader.readLine();
					System.out.println("Enter a number of sets:");
					
					try {
						String setsString = reader.readLine();
						int sets = Integer.parseInt(setsString);
						exerciseBuilder.setSets(sets);
					} catch (Error e) {
						System.out.println("sets must be a number");
					}
					
					try {
						System.out.println("Enter a number of reps");
						String repsString = reader.readLine();
						int reps = Integer.parseInt(repsString);
						exerciseBuilder.setReps(reps);
					} catch (Error e) {
						System.out.println("reps must be a number");
					}
					
					System.out.println("Does this exercise need equipment? (y/n)");
					String needEquipment = reader.readLine();
					
					while (needEquipment.toLowerCase().equals("y")) {
						Equipment found = null;
						System.out.println("Which equipment does it need?");
						String equipmentName = reader.readLine();				
						
						for (Equipment equipment : gymSystem.getEquipment()) {
							if (equipmentName.toLowerCase().equals(equipment.getName().toLowerCase())) {
								found = equipment;
							}
						}
							
						if (found == null) {
							System.out.println("Did not find equipment");
						} else {
							exerciseBuilder.addEquipment(found);
							needEquipment = "n";
						}
					}
					
					System.out.println("Are there more exercises? (y/n)");
					String choice = reader.readLine();
					
					if (choice.toLowerCase().equals("n")) {
						addingExercises = false;				
					}
				}
				
				Exercise exercise = exerciseBuilder.createExercise();
				workoutRoutine.addExercise(exercise);
				System.out.print("\n ***Workout routine updated in system*** \n");
			}
		}
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

	private void createWorkout() throws IOException {
		if (this.manager.equals(this.user)) {
			System.out.println("Not Authorized");
			return;
		}
		
		System.out.println("Enter name of workout:");
		String name = reader.readLine();
		
		WorkoutRoutine workoutRoutine = new WorkoutRoutine(name);
		exerciseBuilder = new ExerciseBuilder();
		
		boolean addingExercises = true;
		while (addingExercises) {
			System.out.println("Enter exercise name: ");
			String exerciseName = reader.readLine();
			exerciseBuilder.setName(exerciseName);
			System.out.println("Enter duration of workout: ");
			String duration = reader.readLine();
			exerciseBuilder.setDuration(duration);
			System.out.println("Enter a number of sets:");
			
			try {
				String setsString = reader.readLine();
				int sets = Integer.parseInt(setsString);
				exerciseBuilder.setSets(sets);
			} catch (Error e) {
				System.out.println("sets must be a number");
			}
			
			try {
				System.out.println("Enter a number of reps");
				String repsString = reader.readLine();
				int reps = Integer.parseInt(repsString);
				exerciseBuilder.setReps(reps);
			} catch (Error e) {
				System.out.println("reps must be a number");
			}			
			
			System.out.println("Does this exercise need equipment? (y/n)");
			String needEquipment = reader.readLine();
			
			while (needEquipment.toLowerCase().equals("y")) {
				Equipment found = null;
				System.out.println("Which equipment does it need?");
				String equipmentName = reader.readLine();				
				
				for (Equipment equipment : gymSystem.getEquipment()) {
					if (equipmentName.toLowerCase().equals(equipment.getName().toLowerCase())) {
						found = equipment;
					}
				}
					
				if (found == null) {
					System.out.println("Did not find equipment");
				} else {
					exerciseBuilder.addEquipment(found);					
					needEquipment = "n";
				}
			}
			
			System.out.println("Are there more exercises? (y/n)");
			String choice = reader.readLine();
			
			if (choice.toLowerCase().equals("n")) {
				addingExercises = false;				
			}
		}
		
		Exercise exercise = exerciseBuilder.createExercise();
		workoutRoutine.addExercise(exercise);
		gymSystem.addWorkoutRoutine(workoutRoutine);
		System.out.print("\n ***Workout routine added to system*** \n");
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
		
		customerCreator.registerCustomer(this.manager);
	}

	private void hireTrainer() throws IOException {
		if (!this.manager.equals(this.user)) {
			System.out.println("Not Authorized");
			return;
		}
		
		trainerCreator.createTrainer(this.manager);
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
