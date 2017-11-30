package edu.colostate.cs.cs414.tba.services;

import edu.colostate.cs.cs414.tba.domain.Address;
import edu.colostate.cs.cs414.tba.domain.Insurance;
import edu.colostate.cs.cs414.tba.domain.PersonalInformation;

public class TrainerInfo {
	private PersonalInformation personalInformation;
	private Insurance insurance;
	private Address address;

	public TrainerInfo(PersonalInformation personalInformation,
			Insurance insurance, Address address) {
		this.personalInformation = personalInformation;
		this.insurance = insurance;
		this.address = address;
	}
	
	public Insurance getInsurance() {
		return this.insurance;
	}
	
	public Address getAddress() {
		return this.address;
	}
	
	public PersonalInformation getPersonalInformation() {
		return this.personalInformation;
	}

}
