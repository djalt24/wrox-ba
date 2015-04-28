package com.wrox.algorithms.stacks;

import java.util.EmptyStackException;

import com.wrox.algorithms.queues.EmptyQueueException;
import com.wrox.algorithms.queues.Queue;

public interface Stack<T> extends Queue<T> {

	void push(T value);
	
	T pop() throws EmptyStackException;
	
	T peek() throws EmptyStackException;

	default void enque(T value) {
		push(value);
	}
	
	default T dequeue()  throws EmptyQueueException {
		try {
			return pop();
		} catch (EmptyQueueException exception) {
			throw new EmptyStackException();
		}
	}
}
