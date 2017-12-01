package edu.colostate.cs.cs414.tba.controllers;

import java.rmi.server.UID;
import java.util.Set;

import edu.colostate.cs.cs414.tba.domain.Equipment;
import edu.colostate.cs.cs414.tba.domain.Exercise;
import edu.colostate.cs.cs414.tba.models.ExerciseModel;

public class ExerciseController implements Controller<Exercise> {
	private ExerciseModel model;
	
	public ExerciseController() {
		model = ExerciseModel.getInstance();
	}
	
	public Exercise create(String name, String duration, int sets, int reps, Equipment equipment) {
		Exercise exercise = new Exercise(name, duration, sets, reps, equipment);
		model.add(exercise);
		return exercise;
	}
		
	@Override
	public Set<Exercise> getAll() {
		return model.get();
	}

	@Override
	public Exercise get(UID id) {
		for (Exercise exercise : model.get()) {
			if (exercise.getId() == id) {
				return exercise;
			}
		}
		
		return null;
	}

	@Override
	public Exercise get(Exercise item) {
		return model.getIndividual(item);
	}

	@Override
	public void delete(Exercise item) {
		model.remove(item);
	}

}
