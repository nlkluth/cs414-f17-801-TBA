package edu.colostate.cs.cs414.tba.application;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import edu.colostate.cs.cs414.tba.gymmanagement.Customer;
import edu.colostate.cs.cs414.tba.gymmanagement.Equipment;
import edu.colostate.cs.cs414.tba.gymmanagement.Manager;
import edu.colostate.cs.cs414.tba.gymmanagement.Trainer;
import edu.colostate.cs.cs414.tba.services.CLIController;

public class GymSystem {
	private Set<Trainer> trainers = new HashSet<Trainer>();
	private Set<Customer> customers = new HashSet<Customer>();
	private Set<Equipment> equipment = new HashSet<Equipment>();
	
	public static void main(String args[]) throws IOException {
		GymSystem gymSystem = new GymSystem();
		Manager manager = new Manager("admin", "admin", gymSystem);
		new CLIController(manager, gymSystem);
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
}
