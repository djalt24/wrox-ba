package com.wrox.algorithms.queues;

/**
 * An interface to a Queue
 * 
 * @author David Nelson
 *
 * @param <T>
 */
public interface Queue<T> {

	/**
	 * Enqueue an entry to the queue
	 * @param value the value to enque
	 */
	void enque(T value);
	
	/**
	 * Dequeues an entry from the queue
	 * @return the value dequeued
	 * @throws EmptyQueueException if the queue is empty
	 */
	T dequeue() throws EmptyQueueException;
	
	/**
	 * Clears the queue of all entries
	 */
	void clear();
	
	/**
	 * Returns the size of the queue (number of entries)
	 * @return the size of the queue (number of entries)
	 */
	int size();
	
	/**
	 * Returns TRUE if the queue is empty
	 * @return TRUE if the queue is empty
	 */
	boolean isEmpty();
}
