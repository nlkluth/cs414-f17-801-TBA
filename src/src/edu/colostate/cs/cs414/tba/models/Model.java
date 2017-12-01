package edu.colostate.cs.cs414.tba.models;

import java.util.Set;

public interface Model<T> {
	public T getIndividual(T item);
	public Set<T> get();
	public void add(T item);
	public void remove(T item);
}
