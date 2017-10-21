package edu.colostate.cs.cs414.tba.gymmanagement;

public class Trainer {
	private PersonalInformation personalInformation;
	private Address address;
	private Insurance insurance;
	private Availability availability;
	
	public Trainer(PersonalInformation personalInformation, Address address, Insurance insurance) {
		this.personalInformation = personalInformation;
		this.address = address;
		this.insurance = insurance;
		availability = Availability.FULLTIME;
	}
	
	@Override
	public boolean equals(Object other) {
		return this.personalInformation.getName() == ((Trainer) other).getPersonalInformation().getName();
	}
	
	public PersonalInformation getPersonalInformation() {
		return this.personalInformation;
	}

	@Override
	public int hashCode() {
		return this.personalInformation.getName().hashCode();
	}
	
	public void setAvailability(Availability availability) {
		this.availability = availability;
	}
	
	public Availability getAvailability() {
		return this.availability;
	}

	public Address getAddress() {
		return this.address;
	}

	public Insurance getInsurance() {
		return this.insurance;
	}

	public void update(PersonalInformation personalInformation,
			Address address, Insurance insurance) {
		this.address = address;
		this.personalInformation = personalInformation;
		this.insurance = insurance;
		
	}
}
