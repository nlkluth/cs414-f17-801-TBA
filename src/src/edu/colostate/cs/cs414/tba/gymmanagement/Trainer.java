package edu.colostate.cs.cs414.tba.gymmanagement;

public class Trainer {
	private PersonalInformation personalInformation;
	private Address address;
	private Insurance insurance;
	private Availability availability;
	private String username;
	private String password;
	
	public Trainer(String username, String password, PersonalInformation personalInformation, Address address, Insurance insurance) {
		this.personalInformation = personalInformation;
		this.address = address;
		this.insurance = insurance;
		this.username = username;
		this.password = password;
		availability = Availability.FULLTIME;
	}
	
	@Override
	public boolean equals(Object other) {
		return this.personalInformation.getName().equals(((Trainer) other).getPersonalInformation().getName());
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

	public String getUsername() {
		return this.username;
	}
	
	public String getPassword() {
		return this.password;
	}
}
