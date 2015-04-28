package com.wrox.algorithms.iteration;

import junit.framework.TestCase;

public class ReverseIteratorTest extends TestCase {
	
	public void testForwardsIterationBecomesBackward() {
		String[] values = {"A","B","C"};
		ArrayIterator<String> ai = new ArrayIterator<>(values);
		
		ReverseIterator<String> ri = new ReverseIterator<>(ai);
		
		ri.first();
		assertFalse(ri.isDone());
		assertSame(ri.current(), values[2]);
		
		ri.next();
		assertFalse(ri.isDone());
		assertSame(ri.current(), values[1]);
		
		ri.next();
		assertFalse(ri.isDone());
		assertSame(ri.current(), values[0]);
		
		ri.next();
		assertTrue(ri.isDone());
		try {
			ri.current();
			fail();
		} catch (Exception ex) {
			// expected
		}
	}
	
	public void testBackwardsIterationBecomesForward() {
		String[] values = {"A","B","C"};
		ArrayIterator<String> ai = new ArrayIterator<>(values);
		
		ReverseIterator<String> ri = new ReverseIterator<>(ai);
		
		ri.last();
		assertFalse(ri.isDone());
		assertSame(ri.current(), values[0]);
		
		ri.previous();
		assertFalse(ri.isDone());
		assertSame(ri.current(), values[1]);
		
		ri.previous();
		assertFalse(ri.isDone());
		assertSame(ri.current(), values[2]);
		
		ri.previous();
		assertTrue(ri.isDone());
		try {
			ri.current();
			fail();
		} catch (Exception ex) {
			// expected
		}	
	}
}
