package edu.colostate.cs.cs414.tba.models;

import java.util.HashSet;
import java.util.Set;

import edu.colostate.cs.cs414.tba.domain.Qualification;

public class QualificationModel implements Model<Qualification> {
	private static QualificationModel model;
	private Set<Qualification> qualifications = new HashSet<Qualification>();


	private QualificationModel() {}
	public static QualificationModel getInstance() {
		if (model == null) {
			model = new QualificationModel();
		}
		
		return model;
	}
	
	@Override
	public Qualification getIndividual(Qualification item) {
		for (Qualification found : qualifications) {
			if (found.equals(item)) {
				return found;
			}
		}
		
		return null;
	}
	
	@Override
	public Set<Qualification> get() {
		return qualifications;
	}

	@Override
	public void add(Qualification item) {
		qualifications.add(item);
	}

	@Override
	public void remove(Qualification item) {
		qualifications.remove(item);
	}

}
