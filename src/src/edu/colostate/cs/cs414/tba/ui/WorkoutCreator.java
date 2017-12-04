package edu.colostate.cs.cs414.tba.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import edu.colostate.cs.cs414.tba.application.ExerciseBuilder;
import edu.colostate.cs.cs414.tba.domain.Customer;
import edu.colostate.cs.cs414.tba.domain.Equipment;
import edu.colostate.cs.cs414.tba.domain.Exercise;
import edu.colostate.cs.cs414.tba.domain.Trainer;
import edu.colostate.cs.cs414.tba.domain.WorkoutRoutine;
import edu.colostate.cs.cs414.tba.services.GymSystem;

public class WorkoutCreator {
	private ExerciseBuilder exerciseBuilder;
	private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));	
	
	public void createWorkout(Trainer user, GymSystem gymSystem) throws IOException {
		System.out.println("Enter name of workout:");
		String name = reader.readLine();
		
		WorkoutRoutine workoutRoutine = new WorkoutRoutine(name);
		exerciseBuilder = new ExerciseBuilder();
		
		buildWorkout(workoutRoutine, gymSystem);
		Exercise exercise = exerciseBuilder.createExercise();
		workoutRoutine.addExercise(exercise);
		gymSystem.addWorkoutRoutine(workoutRoutine);
		System.out.print("\n ***Workout routine added to system*** \n");
	}

	public void assignWorkout(Trainer user, GymSystem gymSystem) throws IOException {
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

	public void modifyRoutine(Trainer user, GymSystem gymSystem) throws IOException {
		System.out.println("Enter name of routine: ");
		String name = reader.readLine();
		if (name == null) {
			name = "";
		}
		
		for (WorkoutRoutine workoutRoutine : gymSystem.getWorkoutRoutines()) {
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
			
				exerciseBuilder = new ExerciseBuilder();
				buildWorkout(workoutRoutine, gymSystem);				
				
				Exercise exercise = exerciseBuilder.createExercise();
				workoutRoutine.addExercise(exercise);
				System.out.print("\n ***Workout routine updated in system*** \n");
			}
		}
	}

	private void buildWorkout(WorkoutRoutine workOut, GymSystem gymSystem) throws IOException {
		boolean addingExercises = true;
		while (addingExercises) {
			System.out.println("Enter exercise name: ");
			String exerciseName = reader.readLine();
			if (exerciseName == null) {
				exerciseName = "";
			}
			
			exerciseBuilder.setName(exerciseName);
			System.out.println("Enter duration of workout: ");
			String duration = reader.readLine();
			if (duration == null) {
				duration = "";
			}
			
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
			if (needEquipment == null) {
				needEquipment = "";
			}
			
			while (needEquipment.toLowerCase().equals("y")) {
				Equipment found = null;
				System.out.println("Which equipment does it need?");
				String equipmentName = reader.readLine();	
				if (equipmentName == null) {
					equipmentName = "";
				}
				
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
			if (choice == null) {
				choice = "n";
			}
			
			if (choice.toLowerCase().equals("n")) {
				addingExercises = false;				
			}
		}
		
	}
}
