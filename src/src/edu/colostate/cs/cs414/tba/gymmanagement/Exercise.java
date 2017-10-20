package edu.colostate.cs.cs414.tba.gymmanagement;

public class Exercise {
	private String name;
	private String duration;
	private int sets;
	private int reps;
	private Equipment equipment;
	
	public Exercise(String name, String duration, int sets, int reps) {
		this.name = name;
		this.duration = duration;
		this.sets = sets;
		this.reps = reps;
	}

	@Override
	public String toString() {
		return this.name + " : " + this.duration + " : "				
				+ Integer.toString(this.reps) + " reps : "
				+ Integer.toString(this.sets) + " sets";
	}
	
	public void update(String name, String duration, int sets, int reps) {
		this.name = name;
		this.duration = duration;
		this.sets = sets;
		this.reps = reps;
	}
	
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
