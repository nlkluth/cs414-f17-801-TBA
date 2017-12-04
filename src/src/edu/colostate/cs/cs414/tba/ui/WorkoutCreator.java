package edu.colostate.cs.cs414.tba.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import edu.colostate.cs.cs414.tba.controllers.CustomerController;
import edu.colostate.cs.cs414.tba.controllers.EquipmentController;
import edu.colostate.cs.cs414.tba.controllers.ExerciseController;
import edu.colostate.cs.cs414.tba.controllers.WorkoutRoutineController;
import edu.colostate.cs.cs414.tba.domain.Customer;
import edu.colostate.cs.cs414.tba.domain.Equipment;
import edu.colostate.cs.cs414.tba.domain.Trainer;
import edu.colostate.cs.cs414.tba.domain.WorkoutRoutine;
import edu.colostate.cs.cs414.tba.services.GymSystem;

/**
 * Used by CLI class to capture all info needed for creating workouts
 */
public class WorkoutCreator {
	private WorkoutRoutineController workoutRoutineController = new WorkoutRoutineController();
	private ExerciseController exerciseController = new ExerciseController();
	private CustomerController customerController = new CustomerController();
	private EquipmentController equipmentController = new EquipmentController();
	private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));	
	
	public void createWorkout(Trainer user, GymSystem gymSystem) throws IOException {
		System.out.println("Enter name of workout:");
		String name = reader.readLine();
		
		WorkoutRoutine workoutRoutine = workoutRoutineController.create(name);		
		
		buildWorkout(workoutRoutine);
		System.out.print("\n ***Workout routine added to system*** \n");
	}

	public void assignWorkout(Trainer user) throws IOException {
		Customer customer = null;
		WorkoutRoutine workout = null;
		
		while (user == null) {
			System.out.println("What is the customer firstName?");
			String name = reader.readLine();
			System.out.println("What is the customer lastName?");
			String lastName = reader.readLine();
			
			for (Customer foundCustomer : customerController.getAll()) {
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
			
			for (WorkoutRoutine foundWorkout : workoutRoutineController.getAll()) {
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

	public void modifyRoutine(Trainer user, GymSystem gymSystem) throws IOException {
		System.out.println("Enter name of routine: ");
		String name = reader.readLine();
		if (name == null) {
			name = "";
		}
		
		for (WorkoutRoutine workoutRoutine : workoutRoutineController.getAll()) {
			if (workoutRoutine.getName().equals(name)) {
				System.out.println("Are there changes to exercises? (y/n)");
				String response = reader.readLine();
				if (response == null) {
					response = "";
				}
				
				if (response.toLowerCase().equals("n")) {
					System.out.println("Nothing to change");
					return;
				}
				
				workoutRoutine.resetExercises(); // reset exercises
							
				buildWorkout(workoutRoutine);
				System.out.print("\n ***Workout routine updated in system*** \n");
			}
		}
	}

	private void buildWorkout(WorkoutRoutine workOut) throws IOException {
		boolean addingExercises = true;
		while (addingExercises) {
			int sets = 0;
			int reps = 0;
			Equipment found = null;
			
			System.out.println("Enter exercise name: ");
			String exerciseName = reader.readLine();
			if (exerciseName == null) {
				exerciseName = "";
			}			
					
			System.out.println("Enter duration of workout: ");
			String duration = reader.readLine();
			if (duration == null) {
				duration = "";
			}
					
			System.out.println("Enter a number of sets:");
			
			try {
				String setsString = reader.readLine();
				sets = Integer.parseInt(setsString);			
			} catch (Error e) {
				System.out.println("sets must be a number");
			}
			
			try {
				System.out.println("Enter a number of reps");
				String repsString = reader.readLine();
				reps = Integer.parseInt(repsString);				
			} catch (Error e) {
				System.out.println("reps must be a number");
			}			
			
			System.out.println("Does this exercise need equipment? (y/n)");
			String needEquipment = reader.readLine();
			if (needEquipment == null) {
				needEquipment = "";
			}
			
			while (needEquipment.toLowerCase().equals("y")) {				
				System.out.println("Which equipment does it need?");
				String equipmentName = reader.readLine();	
				if (equipmentName == null) {
					equipmentName = "";
				}
				
				for (Equipment equipment : equipmentController.getAll()) {
					if (equipmentName.toLowerCase().equals(equipment.getName().toLowerCase())) {
						found = equipment;
					}
				}
					
				if (found == null) {
					System.out.println("Did not find equipment");
				} else {		
					needEquipment = "n";
				}
			}
			
			exerciseController.create(exerciseName, duration, sets, reps, found);
			System.out.println("Are there more exercises? (y/n)");
			String choice = reader.readLine();
			if (choice == null) {
				choice = "n";
			}
			
			if (choice.toLowerCase().equals("n")) {
				addingExercises = false;				
			}
		}
		
	}
}
