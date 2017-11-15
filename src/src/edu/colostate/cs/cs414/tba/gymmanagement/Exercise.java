package edu.colostate.cs.cs414.tba.gymmanagement;

/**
 * Created by trainers and added to work out routines
 * may or may not use equipment from the inventory
 * @param {name} name of exercise
 * @param {duration} duration of exercise
 * @param {sets} number of sets to complete
 * @param {reps} number of reps in each set
 *
 */
public class Exercise {
	private String name;
	private String duration;
	private int sets;
	private int reps;
	private Equipment equipment;
	
	public Exercise(String name, String duration, int sets, int reps, Equipment equipment) {
		this.name = name;
		this.duration = duration;
		this.sets = sets;
		this.reps = reps;
		this.equipment = equipment;
	}

	@Override
	public String toString() {
		return this.name + " : " + this.duration + " : "				
				+ Integer.toString(this.reps) + " reps : "
				+ Integer.toString(this.sets) + " sets";
	}
	
	public void update(String name, String duration, int sets, int reps, Equipment equipment) {
		this.name = name;
		this.duration = duration;
		this.sets = sets;
		this.reps = reps;
		this.equipment = equipment;
	}
	

	// May or may not use a piece of equipment
	public void setEquipment(Equipment equipment) {
		equipment.addExercise(this);
		this.equipment = equipment;
	}
	
	public Equipment getEquipment() {
		return this.equipment;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setDuration(String duration) {
		this.duration = duration;
	}
	
	public String getDuration() {
		return this.duration;
	}
	
	public void setSets(int sets) {
		this.sets = sets;
	}
	
	public int getSets() {
		return this.sets;
	}
	
	public void setReps(int reps) {
		this.reps = reps;
	}
	
	public int getReps() {
		return this.reps;
	}
}
