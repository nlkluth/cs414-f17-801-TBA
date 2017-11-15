package edu.colostate.cs.cs414.tba.services;

import java.io.IOException;

import edu.colostate.cs.cs414.tba.application.GymSystem;
import edu.colostate.cs.cs414.tba.domain.Manager;

/**
 * handles setting up CLI for running the app
 * Call start() to go through motions of starting app
 */
public class CLIControllerFacade {
	private CLIController cliController = CLIController.getInstance();

	public void start(Manager manager, GymSystem gymSystem) throws IOException {
		/**
		 * right now the facade pattern is a bit overkill
		 * but this starting of the application can easily be extended now
		 * to include starting a database etc.
		 */
		cliController.setManager(manager);
		cliController.setGymSystem(gymSystem);
		cliController.start();
	}

}
