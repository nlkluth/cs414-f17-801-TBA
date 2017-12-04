package edu.colostate.cs.cs414.tba.domain;

import edu.colostate.cs.cs414.tba.application.User;

/**
 * Administrator of the system. Created on system initialization
 */
public class Manager extends User {
	private boolean isManager;
	
	public Manager(String username, String password) {
		super(username, password);
		this.isManager = true;
	}
	
	public boolean getIsManager() {
		return this.isManager;
	}
}
