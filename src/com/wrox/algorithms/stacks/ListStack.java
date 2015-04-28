package com.wrox.algorithms.stacks;

import java.util.EmptyStackException;

import com.wrox.algorithms.lists.LinkedList;

public class ListStack<T> implements Stack<T> {
	
	private final LinkedList<T> internal = new LinkedList<T>();
	
	@Override
	public void push(T value) {
		internal.add(value);
	}

	@Override
	public T pop() throws EmptyStackException {
		if (internal.isEmpty()) {
			throw new EmptyStackException();
		}
		return internal.delete(internal.size() - 1);
	}

	@Override
	public T peek() throws EmptyStackException {
		if (internal.isEmpty()) {
			throw new EmptyStackException();
		}
		return internal.get(internal.size() - 1);
	}

	
	@Override
	public int size() {
		return internal.size();
	}

	@Override
	public boolean isEmpty() {
		return internal.isEmpty();
	}

	@Override
	public void clear() {
		internal.clear();
	}
}
