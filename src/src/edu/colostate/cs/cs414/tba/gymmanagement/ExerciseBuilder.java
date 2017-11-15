package edu.colostate.cs.cs414.tba.gymmanagement;

/**
 * Builds an exercise
 */
public class ExerciseBuilder {
	private Exercise exercise;
	private String name;
	private String duration;
	private int sets;
	private int reps;
	private Equipment equipment;
	
	public Exercise createExercise() {
		this.exercise = new Exercise(this.name, this.duration, this.sets, this.reps, this.equipment);
		return this.exercise;
	}
	
	public void addEquipment(Equipment equipment) {
		this.equipment = equipment;
		equipment.addExercise(this.exercise);
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setDuration(String duration) {
		this.duration = duration;
	}
	
	public Exercise getExercise() {
		return this.exercise;
	}
	
	public void setSets(int sets) {
		this.sets = sets;
	}

	public void setReps(int reps) {
		this.reps = reps;
	}
}
