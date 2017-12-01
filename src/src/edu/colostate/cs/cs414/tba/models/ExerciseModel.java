package edu.colostate.cs.cs414.tba.models;

import java.util.HashSet;
import java.util.Set;

import edu.colostate.cs.cs414.tba.domain.Exercise;

public class ExerciseModel implements Model<Exercise> {
	private static ExerciseModel model;
	private Set<Exercise> exercises = new HashSet<Exercise>();
	
	private ExerciseModel() {}
	public static ExerciseModel getInstance() {
		if (model == null) {
			model = new ExerciseModel();
		}
		
		return model;
	}

	@Override
	public Exercise getIndividual(Exercise item) {
		for (Exercise found : exercises) {
			if (found.equals(item)) {
				return found;
			}
		}
		
		return null;
	}

	@Override
	public Set<Exercise> get() {
		return exercises;
	}

	@Override
	public void add(Exercise item) {
		exercises.add(item);
	}

	@Override
	public void remove(Exercise item) {
		exercises.remove(item);
	}

}
