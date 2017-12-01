package edu.colostate.cs.cs414.tba.models;

import java.util.HashSet;
import java.util.Set;

import edu.colostate.cs.cs414.tba.domain.WorkoutRoutine;

public class WorkoutRoutineModel implements Model<WorkoutRoutine> {
	private Set<WorkoutRoutine> workoutRoutines = new HashSet<WorkoutRoutine>();
	private static WorkoutRoutineModel model;
	
	private WorkoutRoutineModel() {}
	public static WorkoutRoutineModel getInstance() {
		if (model == null) {
			model = new WorkoutRoutineModel();
		}
		
		return model;
	}
	
	@Override
	public WorkoutRoutine getIndividual(WorkoutRoutine item) {
		for (WorkoutRoutine workoutRoutine : workoutRoutines) {
			if (workoutRoutine.equals(item)) {
				return workoutRoutine;
			}
		}
		
		return null;
	}

	@Override
	public Set<WorkoutRoutine> get() {
		return workoutRoutines;
	}

	@Override
	public void add(WorkoutRoutine item) {
		workoutRoutines.add(item);
	}

	@Override
	public void remove(WorkoutRoutine item) {
		workoutRoutines.remove(item);
	}

}
