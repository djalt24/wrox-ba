package com.wrox.algorithms.iteration;

import junit.framework.TestCase;

public class SingleValueIteratorTest extends TestCase {

	private String val = "T";
	
	public void testForwardsIteration() {
		
		SingleValueIterator<String> svi = new SingleValueIterator<>(val);
		
		svi.first();
		assertFalse(svi.isDone());
		assertEquals(svi.current(), val);
		
		svi.next();
		assertTrue(svi.isDone());
		
		try {
			svi.current();
			fail();
		} catch (Exception ex) {
			// expected
		}
	}
	
	public void testBackwardsIteration() {
		
		SingleValueIterator<String> svi = new SingleValueIterator<>(val);
		
		svi.last();
		assertFalse(svi.isDone());
		assertEquals(svi.current(), val);
		
		svi.previous();
		assertTrue(svi.isDone());
		
		try {
			svi.current();
			fail();
		} catch (Exception ex) {
			// expected
		}
	}
}
