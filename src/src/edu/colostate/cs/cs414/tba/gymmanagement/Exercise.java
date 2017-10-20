package edu.colostate.cs.cs414.tba.gymmanagement;

public class Exercise {
	private String name;
	private String duration;
	private int sets;
	private int reps;
	
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
}
