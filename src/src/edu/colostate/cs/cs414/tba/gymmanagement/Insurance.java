package edu.colostate.cs.cs414.tba.gymmanagement;

public class Insurance {
	private String name;
	private Address address;
	
	public Insurance(String name, Address address) {
		this.name = name;
		this.address = address;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Address getAddress() {
		return this.address;
	}
	
	@Override
	public boolean equals(Object insurance) {
		return ((Insurance) insurance).getName().equals(name);
	}
	
	@Override
	public String toString() {
		return name + ":\n" + address.toString(); 
	}
	
	@Override
	// used for equality check
	public int hashCode() {
		return this.name.hashCode();
	}
}
