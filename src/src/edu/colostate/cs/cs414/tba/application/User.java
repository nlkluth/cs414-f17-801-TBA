package edu.colostate.cs.cs414.tba.application;

import edu.colostate.cs.cs414.tba.domain.Address;
import edu.colostate.cs.cs414.tba.domain.Insurance;
import edu.colostate.cs.cs414.tba.domain.PersonalInformation;

public interface User {
	public Insurance getInsurance();
	public Address getAddress();
	public void update(PersonalInformation personalInformation, Address address, Insurance insurance);
	public PersonalInformation getPersonalInformation();
}
