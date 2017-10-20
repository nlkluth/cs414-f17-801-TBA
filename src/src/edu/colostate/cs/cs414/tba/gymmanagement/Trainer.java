package edu.colostate.cs.cs414.tba.gymmanagement;

public class Trainer {
	private PersonalInformation personalInformation;
	private Address address;
	private Insurance insurance;
	
	public Trainer(PersonalInformation personalInformation, Address address, Insurance insurance) {
		this.personalInformation = personalInformation;
		this.address = address;
		this.insurance = insurance;
	}
	
	@Override
	public boolean equals(Object other) {
		return this.personalInformation.getName() == ((Trainer) other).getPersonalInformation().getName();
	}
	
	private PersonalInformation getPersonalInformation() {
		return this.personalInformation;
	}

	@Override
	public int hashCode() {
		return this.personalInformation.getName().hashCode();
	}
}
