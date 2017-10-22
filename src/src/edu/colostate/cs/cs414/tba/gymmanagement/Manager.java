package edu.colostate.cs.cs414.tba.gymmanagement;

import edu.colostate.cs.cs414.tba.application.GymSystem;

public class Manager {
	private String username;
	private String password;
	private PersonalInformation personalInformation;
	private Address address;
	private Insurance insurance;
	private GymSystem gymSystem;
	
	public Manager(String username, String password, GymSystem gymSystem) {
		this.username = username;
		this.password = password;
		this.gymSystem = gymSystem;
	}

	public PersonalInformation getPersonalInformation() {
		return this.personalInformation;
	}
	
	public Address getAddress() {
		return this.address;
	}
	
	public Insurance getInsurance() {
		return this.insurance;
	}

	public void setPersonalInformation(PersonalInformation personalInformation) {
		this.personalInformation = personalInformation;
	}

	public void setInsurance(Insurance insurance) {
		this.insurance = insurance;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public void registerCustomer(Customer customer) {
		gymSystem.addCustomer(customer);
	}

	public void hireTrainer(Trainer trainer) {
		gymSystem.addTrainer(trainer);
	}

	public void addEquipment(Equipment equipment) {
		gymSystem.addEquipment(equipment);
	}
}
