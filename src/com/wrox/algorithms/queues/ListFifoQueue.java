package com.wrox.algorithms.queues;

import com.wrox.algorithms.lists.LinkedList;
import com.wrox.algorithms.lists.List;

public class ListFifoQueue<T> implements Queue<T> {
	
	private final List<T> internal;
	
	public ListFifoQueue(final List<T> initial) {
		assert initial != null : "initial input list cannot be null";
		
		internal = initial;
	}
	
	public ListFifoQueue() {
		internal = new LinkedList<T>();
	}

	@Override
	public void enque(T value) {
		assert value != null : "value cannot be null";
		internal.add(value);
	}

	@Override
	public T dequeue() throws EmptyQueueException {
		if (internal.isEmpty()) {
			throw new EmptyQueueException();
		}
		
		return internal.delete(0);
	}

	@Override
	public void clear() {
		internal.clear();
	}

	@Override
	public int size() {
		return internal.size();
	}

	@Override
	public boolean isEmpty() {
		return internal.isEmpty();
	}
}
