package edu.colostate.cs.cs414.tba.tests;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import edu.colostate.cs.cs414.tba.domain.Address;
import edu.colostate.cs.cs414.tba.domain.Customer;
import edu.colostate.cs.cs414.tba.domain.Equipment;
import edu.colostate.cs.cs414.tba.domain.Insurance;
import edu.colostate.cs.cs414.tba.domain.PersonalInformation;
import edu.colostate.cs.cs414.tba.domain.Trainer;
import edu.colostate.cs.cs414.tba.services.GymSystem;

public class GymSystemTest {
	private GymSystem gymSystem;
	
	@Before public void setUp() {
		gymSystem = new GymSystem();
	}
}
