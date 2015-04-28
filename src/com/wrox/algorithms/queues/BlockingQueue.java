package com.wrox.algorithms.queues;

/**
 * A Wrapper of a Queue which synchronizes and blocks
 * 
 * @author David Nelson
 *
 * @param <T> the type of data in the queue
 */
public class BlockingQueue<T> implements Queue<T> {
	
	/** the mutex */
	private final Object mutex = new Object();
	
	/** the internal (wrapped) queue */
	private final Queue<T> internal;
	
	/** the max size of the queue */
	private final int maxSize;
	
	/**
	 * Constructor
	 * @param queue the queue to wrap with synchronized blocking
	 */
	public BlockingQueue(Queue<T> queue) {
		this(queue, Integer.MAX_VALUE);
	}
	
	/**
	 * Constructor
	 * @param queue the queue to wrap with synchronized blocking
	 * @param maxEntries the maximum entries to allow before blocking
	 */
	public BlockingQueue(Queue<T> queue, int maxEntries) {
		internal = queue;
		maxSize = maxEntries;
	}

	@Override
	public void enque(T value) {
		synchronized(mutex) {
			while(size() == maxSize) {
				waitForNotification();
			}
			internal.enque(value);
			mutex.notifyAll();
		}
	}

	@Override
	public T dequeue() throws EmptyQueueException {
		while (internal.isEmpty()) {
			waitForNotification();
		}
		synchronized(mutex) {
			T rv = internal.dequeue();
			mutex.notifyAll();
			return rv;
		}
	}

	@Override
	public void clear() {
		synchronized(mutex) {
			internal.clear();
			mutex.notifyAll();
		}
	}

	@Override
	public int size() {
		synchronized(mutex) {
			return internal.size();
		}
	}

	@Override
	public boolean isEmpty() {
		synchronized(mutex) {
			return internal.isEmpty();
		}
	}
	
	/**
	 * A mutex wait mechanism
	 */
	private void waitForNotification() {
		try {
			mutex.wait();
		} catch (InterruptedException e) {
			// ignore
		}
	}
}
