package edu.colostate.cs.cs414.tba.controllers;

import java.rmi.server.UID;
import java.util.Set;

import edu.colostate.cs.cs414.tba.domain.Qualification;
import edu.colostate.cs.cs414.tba.domain.Trainer;
import edu.colostate.cs.cs414.tba.models.QualificationModel;


/**
 * Manages Qualification domain and QualificationModel classes
 */
public class QualificationController implements Controller<Qualification> {
	private QualificationModel model;
	
	public QualificationController() {
		model = QualificationModel.getInstance();
	}
	
	public Qualification create(String name, Trainer trainer) {
		Qualification qualification = new Qualification(name);
		model.add(qualification);
		 
		// find the qualification again in case it was a duplicate
		Qualification found = model.getIndividual(qualification);
		found.addTrainer(trainer);
		return found;
	}
	
	@Override
	public Set<Qualification> getAll() {
		return model.get();
	}

	@Override
	public Qualification get(UID id) {
		for (Qualification qualification : model.get()) {
			if (qualification.getId() == id) {
				return qualification;
			}
		}
		
		return null;
	}

	@Override
	public Qualification get(Qualification item) {
		return model.getIndividual(item);
	}

	@Override
	public void delete(Qualification item) {
		model.remove(item);
	}

}
