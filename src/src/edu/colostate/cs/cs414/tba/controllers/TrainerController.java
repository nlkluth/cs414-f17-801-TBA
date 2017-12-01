package edu.colostate.cs.cs414.tba.controllers;

import java.rmi.server.UID;
import java.util.Set;

import edu.colostate.cs.cs414.tba.domain.Address;
import edu.colostate.cs.cs414.tba.domain.Insurance;
import edu.colostate.cs.cs414.tba.domain.PersonalInformation;
import edu.colostate.cs.cs414.tba.domain.Trainer;
import edu.colostate.cs.cs414.tba.models.TrainerModel;

public class TrainerController implements Controller<Trainer> {
	private TrainerModel model;
	
	public TrainerController() {
		model = TrainerModel.getInstance();
	}
	
	public Trainer create(String username, String password, PersonalInformation personalInformation, Address address, Insurance insurance) {
		Trainer trainer = new Trainer(username, password, personalInformation, address, insurance);
		model.add(trainer);
		return trainer;
	}

	@Override
	public Set<Trainer> getAll() {
		return model.get();
	}

	@Override
	public Trainer get(UID id) {
		for (Trainer trainer : model.get()) {
			if (trainer.getId() == id) {
				return trainer;
			}
		}
		
		return null;
	}

	@Override
	public Trainer get(Trainer item) {
		return model.getIndividual(item);
	}

	@Override
	public void delete(Trainer item) {
		model.remove(item);
	}

}
