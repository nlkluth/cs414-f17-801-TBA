package edu.colostate.cs.cs414.tba.domain;

import java.io.File;
import java.rmi.server.UID;
import java.util.HashSet;
import java.util.Set;

/**
 * Equipment class represents any item in the gym's inventory
 * @param {name} the name of the equipment
 * @param {img} the picture of the equipment
 * @param {quality} a quality rating 
 *
 */
public class Equipment {
	private String name;
	private File img;
	private String quality;
	private Set<Exercise> exercises = new HashSet<Exercise>();
	private UID id;

	public Equipment(String name, File img, String quality) {
		this.name = name;
		this.img = img;
		this.quality = quality;
		this.id = new UID();
	}
	
	public File getImage() {
		return this.img;
	}
	
	// equipment may be used by an exercise
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
	// used for equality checks
	public int hashCode() {
		return this.name.hashCode();
	}
	
	@Override
	public boolean equals(Object other) {
		if ((other == null) || (this == null)) {
	        return false;
	    }
		
		return ((Equipment) other).getName().equals(this.name);
	}

	public void update(String name, File file, String quality) {
		this.name = name;
		this.img = file;
		this.quality = quality;
	}

	public UID getId() {
		return this.id;
	}
}
