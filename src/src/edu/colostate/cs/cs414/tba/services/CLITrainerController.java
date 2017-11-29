package edu.colostate.cs.cs414.tba.services;

import java.io.IOException;

import edu.colostate.cs.cs414.tba.application.GymSystem;
import edu.colostate.cs.cs414.tba.domain.Customer;
import edu.colostate.cs.cs414.tba.domain.Manager;
import edu.colostate.cs.cs414.tba.domain.Trainer;
import edu.colostate.cs.cs414.tba.domain.WorkoutRoutine;
import edu.colostate.cs.cs414.tba.gymmanagement.User;

public class CLITrainerController {
	private WorkoutCreator workoutCreator = new WorkoutCreator();
	private Manager manager;
	private User user;
	private GymSystem gymSystem;
	
	public CLITrainerController(Manager manager, Object user, GymSystem gymSystem) {
		this.gymSystem = gymSystem;
		this.manager = manager;
		this.user = (User) user;	
	}
	
	public void input(String input) throws IOException {	
		switch (input) {
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
		}
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

}
