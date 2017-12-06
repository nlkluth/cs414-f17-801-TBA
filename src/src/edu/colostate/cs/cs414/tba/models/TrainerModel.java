package edu.colostate.cs.cs414.tba.models;

import java.util.HashSet;
import java.util.Set;

import edu.colostate.cs.cs414.tba.domain.Trainer;

/**
 * Handles persistence and retrieval of trainer
 */
public class TrainerModel implements Model<Trainer> {
	private static Set<Trainer> trainers = new HashSet<Trainer>();
	private static TrainerModel model;
	
	private TrainerModel() {}
	public static TrainerModel getInstance() {
		if (model == null) {
			model = new TrainerModel();
		}
		
		return model;
	}
	
	@Override
	public Trainer getIndividual(Trainer item) {
		for (Trainer trainer : trainers) {
			if (trainer.equals(item)) {
				return trainer;
			}
		}
		
		return null;
	}

	@Override
	public Set<Trainer> get() {
		return trainers;
	}

	@Override
	public void add(Trainer item) {
		trainers.add(item);
	}

	@Override
	public void remove(Trainer item) {
		trainers.remove(item);
	}

}
