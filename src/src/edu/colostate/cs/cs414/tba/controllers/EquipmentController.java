package edu.colostate.cs.cs414.tba.controllers;

import java.io.File;
import java.rmi.server.UID;
import java.util.Set;

import edu.colostate.cs.cs414.tba.domain.Equipment;
import edu.colostate.cs.cs414.tba.models.EquipmentModel;

public class EquipmentController implements Controller<Equipment> {
	private EquipmentModel model;
	
	public EquipmentController() {
		model = EquipmentModel.getInstance();
	}
	
	public Equipment create(String name, File img, String quality) {
		Equipment equipment = new Equipment(name, img, quality);
		model.add(equipment);
		return equipment;
	}
	
	@Override
	public Set<Equipment> getAll() {
		return model.get();
	}

	@Override
	public Equipment get(UID id) {
		for (Equipment equipment : model.get()) {
			if (equipment.getId() == id) {
				return equipment;
			}
		}
		
		return null;
	}

	@Override
	public Equipment get(Equipment item) {
		return model.getIndividual(item);
	}

	@Override
	public void delete(Equipment item) {
		model.remove(item);
	}

}
