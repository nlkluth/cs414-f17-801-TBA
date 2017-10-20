package edu.colostate.cs.cs414.tba.services;

import java.util.HashSet;
import java.util.Set;

import edu.colostate.cs.cs414.tba.gymmanagement.Customer;
import edu.colostate.cs.cs414.tba.gymmanagement.Equipment;
import edu.colostate.cs.cs414.tba.gymmanagement.Manager;
import edu.colostate.cs.cs414.tba.gymmanagement.Trainer;
import edu.colostate.cs.cs414.tba.gymmanagement.WorkoutRoutine;

/**
 * Persistence mock DB
 * Stores in memory, in production this would link to a real DB
 */
public class DatabaseController {
	private Set<Equipment> equipment = new HashSet<Equipment>();
	private Set<Customer> customers = new HashSet<Customer>();
	private Set<Trainer> trainers = new HashSet<Trainer>();
	private Set<WorkoutRoutine> workoutRoutines = new HashSet<WorkoutRoutine>();
	
	private Manager manager;
	
	public DatabaseController() {
		manager = new Manager("admin", "admin");
	}
}
