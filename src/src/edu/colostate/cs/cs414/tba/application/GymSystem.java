package edu.colostate.cs.cs414.tba.application;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import edu.colostate.cs.cs414.tba.domain.Customer;
import edu.colostate.cs.cs414.tba.domain.Equipment;
import edu.colostate.cs.cs414.tba.domain.Manager;
import edu.colostate.cs.cs414.tba.domain.Trainer;
import edu.colostate.cs.cs414.tba.domain.WorkoutRoutine;
import edu.colostate.cs.cs414.tba.services.CLIController;
import edu.colostate.cs.cs414.tba.services.CLIControllerFacade;

/**
 * GymSystem represents the overall system
 * it also acts as a in-memory database for this
 * small demo project
 *
 */
public class GymSystem {
	private Set<Trainer> trainers = new HashSet<Trainer>();
	private Set<Customer> customers = new HashSet<Customer>();
	private Set<Equipment> equipment = new HashSet<Equipment>();
	private Set<WorkoutRoutine> workoutRoutines = new HashSet<WorkoutRoutine>();	
	private static CLIControllerFacade cliController = new CLIControllerFacade();
	
	public static void main(String args[]) throws IOException {
		GymSystem gymSystem = new GymSystem();
		Manager manager = new Manager("admin", "admin", gymSystem);
		
		cliController.start(manager, gymSystem);
	}
	
	public void addCustomer(Customer customer) {
		this.customers.add(customer);
	}
	
	public Set<Customer> getCustomers() {
		return this.customers;
	}
	
	public void addTrainer(Trainer trainer) {
		this.trainers.add(trainer);
	}
	
	public Set<Trainer> getTrainers() {
		return this.trainers;
	}
	
	public void addEquipment(Equipment equipment) {
		this.equipment.add(equipment);
	}
	
	public Set<Equipment> getEquipment() {
		return this.equipment;
	}
	
	public void addWorkoutRoutine(WorkoutRoutine workoutRoutine) {
		this.workoutRoutines.add(workoutRoutine);
	}
	
	public Set<WorkoutRoutine> getWorkoutRoutines() {
		return this.workoutRoutines;
	}
}
