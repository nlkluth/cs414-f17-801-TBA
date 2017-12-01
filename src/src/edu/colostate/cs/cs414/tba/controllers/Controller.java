package edu.colostate.cs.cs414.tba.controllers;

import java.rmi.server.UID;
import java.util.Set;

public interface Controller<T> {
	// create
	// update
	
	public Set<T> getAll();
	public T get(UID id);
	public T get(T item);
	public void delete(T item);
}
