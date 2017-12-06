package edu.colostate.cs.cs414.tba.models;

import java.util.HashSet;
import java.util.Set;

import edu.colostate.cs.cs414.tba.domain.Equipment;

/**
 * Handles persistence and retrieval of equipment
 */
public class EquipmentModel implements Model<Equipment>{
	private Set<Equipment> equipment = new HashSet<Equipment>();
	private static EquipmentModel model;
	
	private EquipmentModel() {}
	public static EquipmentModel getInstance() {
		if (model == null) {
			model = new EquipmentModel();
		}
		
		return model;
	}
	
	@Override
	public Equipment getIndividual(Equipment item) {
		for (Equipment equipmentItem : equipment) {
			if (equipmentItem.equals(item)) {
				return equipmentItem;
			}
		}
		
		return null;
	}

	@Override
	public Set<Equipment> get() {
		return equipment;
	}

	@Override
	public void add(Equipment item) {
		equipment.add(item);
	}

	@Override
	public void remove(Equipment item) {
		equipment.remove(item);
	}

}
