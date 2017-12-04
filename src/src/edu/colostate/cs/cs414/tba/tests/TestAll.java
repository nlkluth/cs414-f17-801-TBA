package edu.colostate.cs.cs414.tba.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import junit.framework.JUnit4TestAdapter;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	AddressTest.class,
	CustomerControllerTest.class,
	CustomerModelTest.class,
	CustomerTest.class,
	EquipmentControllerTest.class,
	EquipmentModelTest.class,
	EquipmentTest.class,
	ExerciseControllerTest.class,
	ExerciseModelTest.class,
	ExerciseTest.class,
	GymSystemTest.class,
	InsuranceTest.class,
	ManagerTest.class,
	PersonalInformationTest.class,
	QualificationTest.class,
	QualificationControllerTest.class,
	QualificationModelTest.class,
	TrainerControllerTest.class,
	TrainerModelTest.class,
	TrainerTest.class,
	WorkoutRoutineControllerTest.class,
	WorkoutRoutineModelTest.class,
	WorkoutRoutineTest.class
})

/**
 * Run this file in eclipse or directly in command line
 * to run all tests
 *
 */
public class TestAll {
	public static void main (String[] args) {
		junit.textui.TestRunner.run(suite());
	}
	
	public static junit.framework.Test suite() {
		return new JUnit4TestAdapter(TestAll.class);
	}
}
