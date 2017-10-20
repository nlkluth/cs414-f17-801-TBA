package edu.colostate.cs.cs414.tba.gymmanagement;

public class Address {
	private String street;
	private String street2;
	private String city;
	private String state;
	private String zip;
	
	public Address(String street, String street2, String city, String state, String zip) {
		this.street = street;
		this.street2 = street2;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}
	
	@Override
	public String toString() {
		return this.street + " " + this.street2 +
				", " + this.city + " " + this.state + ", "
				+ this.zip;
	}
}
