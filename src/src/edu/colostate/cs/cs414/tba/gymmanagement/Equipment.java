package edu.colostate.cs.cs414.tba.gymmanagement;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

public class Equipment {
	private String name;
	private File img;
	private String quality;
	private Set<Exercise> exercises = new HashSet<Exercise>();

	public Equipment(String name, File img, String quality) {
		this.name = name;
		this.img = img;
		this.quality = quality;
	}
	
	public File getImage() {
		return this.img;
	}
	
	public void addExercise(Exercise exercise) {
		this.exercises.add(exercise);
	}
	
	public String getName() {
		return this.name;
	}

	public Set<Exercise> getExercises() { 
		return this.exercises;
	}
	
	@Override
	public String toString() {
		return this.name + " : " + this.quality;
	}
	
	@Override
	public boolean equals(Object other) {
		return ((Equipment) other).getName().equals(this.name);
	}
}
