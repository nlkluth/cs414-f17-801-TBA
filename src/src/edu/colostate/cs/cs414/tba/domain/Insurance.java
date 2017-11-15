package edu.colostate.cs.cs414.tba.gymmanagement;

/**
 * All members staff or customers have health insurance providers
 * @param {name} the name of the provider
 * @param {Address} the location of the provider
 */
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
