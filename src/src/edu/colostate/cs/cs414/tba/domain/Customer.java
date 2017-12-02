package edu.colostate.cs.cs414.tba.domain;

import edu.colostate.cs.cs414.tba.application.Membership;
import edu.colostate.cs.cs414.tba.application.User;

/**
 * Customers are created by managers and managed by trainers
 * Can be assigned to workouts and searched for
 *
 */
public class Customer extends User {
	private Membership membership;
	
	public Customer(String username, String password) {
		super(username, password);
		this.membership = Membership.ACTIVE;
	}
	
	public void setActive(Membership membership) {
		// membership status changed, defaults to active
		this.membership = membership;
	}
	
	public Membership getMembership() {
		return this.membership;
	}
//
//	public Set<WorkoutRoutine> getWorkoutRoutines() {
//		return this.workouts;
//	}
//
//	// customers may be assigned by trainers to workout routines
//	public void addWorkoutRoutine(WorkoutRoutine workout) {
//		this.workouts.add(workout);
//	}
}
