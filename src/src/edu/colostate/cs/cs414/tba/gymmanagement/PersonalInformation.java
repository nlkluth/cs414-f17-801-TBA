package edu.colostate.cs.cs414.tba.gymmanagement;

/**
 * Stores common personal information for users of the system and customers
 * @param {name} the name of this person
 * @param {lastName} lastName of person
 * @param {phone} phone number for person
 * @param {email} email for person
 */
public class PersonalInformation {
	private String name;
	private String lastName;
	private String phone;
	private String email;
	
	public PersonalInformation(String name, String lastName, String phone, String email) {
		this.name = name;
		this.lastName = lastName;
		this.phone = phone;
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "User: " + this.name + " " + this.lastName + "\n"
				+ "phone: " + this.phone + "\n"
				+ "email: " + this.email;
	}
	
	public String getName() {
		return this.name + " " + this.lastName;
	}
	
	public String getPhone() {
		return this.phone;
	}
	
	public String getEmail() {
		return this.email;
	}
}
