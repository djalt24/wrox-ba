package com.wrox.algorithms.queues;

import com.wrox.algorithms.sorting.Comparator;
import com.wrox.algorithms.sorting.NaturalComparator;

import junit.framework.TestCase;

public abstract class AbstractPriorityQueueTestCase<T extends Comparable<T>>
		extends TestCase {
	
	private final T smallest;
	
	private final T valueB;
	
	private final T valueC;
	
	private final T valueD;
	
	private final T largest;

	private Queue<T> queue;
	
	public AbstractPriorityQueueTestCase(T small, T val2, T val3, T val4, T large) {
		smallest = small;
		valueB   = val2;
		valueC   = val3;
		valueD   = val4;
		largest  = large;
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();

		queue = createQueue(new NaturalComparator<T>());
	}

	@Override
	protected void tearDown() throws Exception {
		queue = null;

		super.tearDown();
	}
	
	public void testAccessAnEmptyQueue() {
		assertEquals(0, queue.size());
		assertTrue(queue.isEmpty());
		
		try {
			queue.dequeue();
			fail();
		} catch (Exception ex) {
			// expected
		}	
	}
	
	public void testEnqueDeque() {
		// dequeue first
		queue.enque(smallest);
		queue.enque(valueC);
		queue.enque(largest);
		
		assertEquals(3, queue.size());
		assertEquals(largest, queue.dequeue());
		
		assertEquals(2, queue.size());
		assertEquals(valueC, queue.dequeue());
		
		assertEquals(1, queue.size());
		assertEquals(smallest, queue.dequeue());
		
		assertEquals(0, queue.size());
		assertTrue(queue.isEmpty());
		
		// enqueue last
		queue.enque(smallest);
		assertEquals(1, queue.size());
		assertFalse(queue.isEmpty());
		
		queue.enque(valueC);
		assertEquals(2, queue.size());
		
		queue.enque(largest);
		assertEquals(3, queue.size());
		
		queue.enque(valueB);
		assertEquals(4, queue.size());
		
		queue.enque(valueD);
		assertEquals(5, queue.size());
		
		// final round of deque
		assertEquals(largest, queue.dequeue());
		assertEquals(4, queue.size());
		
		assertEquals(valueD, queue.dequeue());
		assertEquals(3, queue.size());
		
		assertEquals(valueC, queue.dequeue());
		assertEquals(2, queue.size());
		
		assertEquals(valueB, queue.dequeue());
		assertEquals(1, queue.size());
		
		assertEquals(smallest, queue.dequeue());
		assertEquals(0, queue.size());
		
		assertTrue(queue.isEmpty());
		
		try {
			queue.dequeue();
			fail();
		} catch (Exception ex) {
			// expected
		}
	}
	
	public void testClear() {
		queue.enque(smallest);
		queue.enque(valueB);
		queue.enque(largest);
		
		queue.clear();
		
		assertTrue(queue.isEmpty());
		
		try {
			queue.dequeue();
			fail();
		} catch (Exception ex) {
			// expected
		}
	}

	protected abstract Queue<T> createQueue(Comparator<T> comparator);

}
