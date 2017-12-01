package edu.colostate.cs.cs414.tba.controllers;

import java.rmi.server.UID;
import java.util.Set;

import edu.colostate.cs.cs414.tba.domain.WorkoutRoutine;
import edu.colostate.cs.cs414.tba.models.WorkoutRoutineModel;

public class WorkoutRoutineController implements Controller<WorkoutRoutine> {
	private WorkoutRoutineModel model;
	
	public WorkoutRoutineController() {
		model = WorkoutRoutineModel.getInstance();
	}
	
	public WorkoutRoutine create(String name) {
		WorkoutRoutine workout = new WorkoutRoutine(name);
		model.add(workout);
		return workout;
	}
	
	@Override
	public Set<WorkoutRoutine> getAll() {
		return model.get();
	}

	@Override
	public WorkoutRoutine get(UID uid) {
		Set<WorkoutRoutine> workouts = model.get();
		for (WorkoutRoutine workout : workouts) {
			if (workout.getId() == uid) {
				return workout;
			}
		}
		
		return null;
	}

	@Override
	public WorkoutRoutine get(WorkoutRoutine item) {
		return model.getIndividual(item);
	}

	@Override
	public void delete(WorkoutRoutine item) {
		model.remove(item);
	}

}
