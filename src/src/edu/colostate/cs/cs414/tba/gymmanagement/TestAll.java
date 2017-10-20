package edu.colostate.cs.cs414.tba.gymmanagement;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import edu.colostate.cs.cs414.tba.application.GymSystemTest;
import junit.framework.JUnit4TestAdapter;

@RunWith(Suite.class)
@Suite.SuiteClasses({ 
	AddressTest.class,
	CustomerTest.class,
	EquipmentTest.class,
	ExerciseTest.class,
	GymSystemTest.class,
	InsuranceTest.class,
	ManagerTest.class,
	PersonalInformationTest.class,
	QualificationTest.class,
	TrainerTest.class,
	WorkoutRoutineTest.class
})

public class TestAll {
	public static void main (String[] args) {
		junit.textui.TestRunner.run(suite());
	}
	
	public static junit.framework.Test suite() {
		return new JUnit4TestAdapter(TestAll.class);
	}
}
