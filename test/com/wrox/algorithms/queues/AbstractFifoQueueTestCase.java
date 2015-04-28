package com.wrox.algorithms.queues;

import junit.framework.TestCase;

public abstract class AbstractFifoQueueTestCase<T> extends TestCase {

	private final T valueA;
	
	private final T valueB;
	
	private final T valueC;
	
	private Queue internal;
	
	public AbstractFifoQueueTestCase(T valA, T valB, T valC) {
		valueA = valA;
		valueB = valB;
		valueC = valC;
	}
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		
		internal = createFifoQueue();
	}
	
	public void testAccessAnEmptyQueue() {
		assertEquals(0, internal.size());
		assertTrue(internal.isEmpty());
		
		try {
			internal.dequeue();
			fail();
		} catch (Exception ex) {
			// expected
		}
	}
	
	public void testEnqueDequeue() {
		internal.enque(valueA);
		internal.enque(valueB);
		internal.enque(valueC);
		
		assertEquals(3, internal.size());
		assertFalse(internal.isEmpty());
		
		assertSame(valueA, internal.dequeue());
		assertEquals(2, internal.size());
		assertFalse(internal.isEmpty());
		
		assertSame(valueB, internal.dequeue());
		assertEquals(1, internal.size());
		assertFalse(internal.isEmpty());
		
		assertSame(valueC, internal.dequeue());
		assertEquals(0, internal.size());
		assertTrue(internal.isEmpty());
		
		try {
			internal.dequeue();
			fail();
		} catch (Exception ex) {
			// expected
		}
	}
	
	public void testClear() {
		internal.enque(valueA);
		internal.enque(valueB);
		internal.enque(valueC);
		
		assertEquals(3, internal.size());
		assertFalse(internal.isEmpty());
		
		internal.clear();
		
		assertEquals(0, internal.size());
		assertTrue(internal.isEmpty());
		
		try {
			internal.dequeue();
			fail();
		} catch (Exception ex) {
			// expected
		}
	}
	
	protected abstract Queue createFifoQueue();
	
}
