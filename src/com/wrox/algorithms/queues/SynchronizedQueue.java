package com.wrox.algorithms.queues;

/**
 * Chapter 4 Exercise 1
 * Design a thread-safe queue with no waiting
 * 
 * @author David Nelson
 *
 */
public class SynchronizedQueue<T> implements Queue<T> {

	/** the mutex */
	private final Object mutex = new Object();
	
	/** the wrapped queue */
	private final Queue<T> internal;
	
	/**
	 * Constructor
	 * @param queue the queue to wrap
	 */
	public SynchronizedQueue(Queue<T> queue) {
		internal = queue;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void enque(T value) {
		synchronized(mutex) {
			internal.enque(value);
			mutex.notifyAll();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public T dequeue() throws EmptyQueueException {
		synchronized(mutex) {
			T rv = internal.dequeue();
			mutex.notifyAll();
			return rv;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void clear() {
		synchronized(mutex) {
			internal.clear();
			mutex.notifyAll();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int size() {
		synchronized(mutex) {
			return internal.size();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isEmpty() {
		synchronized(mutex) {
			return internal.isEmpty();
		}
	}
}
