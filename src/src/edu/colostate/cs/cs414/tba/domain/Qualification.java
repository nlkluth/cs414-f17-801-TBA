package edu.colostate.cs.cs414.tba.domain;

import java.rmi.server.UID;
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
	private UID id;
	
	public Qualification(String name) {
		this.name = name;
		this.id = new UID();
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
	
	public UID getId() {
		return this.id;
	}
	
	public void setId(UID id) {
		this.id = id;
	}
}
