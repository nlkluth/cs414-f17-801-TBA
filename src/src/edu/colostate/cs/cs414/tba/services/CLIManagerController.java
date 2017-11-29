package edu.colostate.cs.cs414.tba.services;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import edu.colostate.cs.cs414.tba.application.GymSystem;
import edu.colostate.cs.cs414.tba.domain.Equipment;
import edu.colostate.cs.cs414.tba.domain.Manager;
import edu.colostate.cs.cs414.tba.gymmanagement.User;

public class CLIManagerController {
	private CustomerCreator customerCreator = new CustomerCreator();
	private TrainerCreator trainerCreator = new TrainerCreator();
	private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	private GymSystem gymSystem;
	private Manager manager;
	private User user;
	
	public CLIManagerController(Manager manager, Object user, GymSystem gymSystem) {
		this.gymSystem = gymSystem;
		this.manager = manager;
		this.user = (User) user;	
	}
	
	public void input(String input) throws IOException {
		switch (input) {
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
