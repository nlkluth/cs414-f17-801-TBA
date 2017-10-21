package edu.colostate.cs.cs414.tba.gymmanagement;

public class Customer {
	private PersonalInformation personalInformation;
	private Address address;
	private Insurance insurance;
	
	public Customer(PersonalInformation personalInformation, Address address, Insurance insurance) {
		this.personalInformation = personalInformation;
		this.address = address;
		this.insurance = insurance;
	}
	
	public PersonalInformation getPersonalInformation() {
		return this.personalInformation;
	}
	
	@Override
	public boolean equals(Object other) {
		return this.personalInformation.getName() == ((Customer) other).getPersonalInformation().getName(); 
	}
}
