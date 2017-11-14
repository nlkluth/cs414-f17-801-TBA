package edu.colostate.cs.cs414.tba.gymmanagement;

public interface User {
	public Insurance getInsurance();
	public Address getAddress();
	public void update(PersonalInformation personalInformation, Address address, Insurance insurance);
	public PersonalInformation getPersonalInformation();
}
