package edu.colostate.cs.cs414.tba.services;

import java.io.IOException;

import edu.colostate.cs.cs414.tba.application.UserFactory;
import edu.colostate.cs.cs414.tba.domain.Manager;
import edu.colostate.cs.cs414.tba.ui.CLIFacade;

/**
 * GymSystem represents the overall system
 * Starting the application runs main()
 */
public class GymSystem {
	private static UserFactory userFactory = new UserFactory();
	private static CLIFacade cliController = new CLIFacade();
	
	public static void main(String args[]) throws IOException {
		GymSystem gymSystem = new GymSystem();
		Manager manager = (Manager) userFactory.createUser("manager", "admin", "admin");
		
		cliController.start(manager, gymSystem);
	}
}
