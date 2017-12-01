package edu.colostate.cs.cs414.tba.controllers;

import java.util.Set;

public interface Controller<T> {
	// create
	// update
	
	public Set<T> getAll();
	public T get(int id);
	public T get(T item);
	public void delete(int id);
	public void delete(T item);
}
