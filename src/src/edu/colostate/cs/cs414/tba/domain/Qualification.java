package edu.colostate.cs.cs414.tba.gymmanagement;

import java.util.HashSet;
import java.util.Set;

/**
 * Trainer qualification 
 * @param {name} the name of the qualification
 *
 */
public class Qualification {
	private String name;
	private Set<Trainer> trainers = new HashSet<Trainer>();
	
	public Qualification(String name) {
		this.name = name;
	}

	public void addTrainer(Trainer trainer) {
		this.trainers.add(trainer);
	}

	public Set<Trainer> getTrainers() {
		return this.trainers;
	}
	
	@Override
	public String toString() {
		return this.name;
	}
}
