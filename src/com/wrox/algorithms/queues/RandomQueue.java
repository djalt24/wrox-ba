package com.wrox.algorithms.queues;

import java.util.Random;

import com.wrox.algorithms.lists.ArrayList;
import com.wrox.algorithms.lists.List;

/**
 * Chapter 4 Exercise 2
 * Design a queue the returns a random entry from the queue when dequeuing.
 * 
 * @author David Nelson
 *
 * @param <T> the type of object in the queue
 */
public class RandomQueue<T> implements Queue<T> {
	
	/**
	 * Using an ArrayList because it's retrieval is faster than linked list
	 * this implementation will be randomly deleting and returning list entries
	 */
	private final List<T> internal = new ArrayList<T>();
	
	/**
	 * The random utility
	 */
	private static final Random RANDOM = new Random();

	@Override
	public void enque(T value) {
		internal.add(value);
	}

	@Override
	public T dequeue() throws EmptyQueueException {
		if (internal.isEmpty()) {
			throw new EmptyQueueException();
		}
		
		return internal.delete(RANDOM.nextInt(internal.size()));
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
