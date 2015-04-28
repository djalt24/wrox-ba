package com.wrox.algorithms.iteration;

import junit.framework.TestCase;

public class ArrayIteratorTest extends TestCase {
	
	public void testIterationRespectsBounds() {
		String[] values = {"A", "B", "C", "D", "E", "F"};
		ArrayIterator<String> ai = new ArrayIterator<>(values, 1, 3);
		
		ai.first();
		assertFalse(ai.isDone());
		assertSame(values[1], ai.current());
		
		ai.next();
		assertFalse(ai.isDone());
		assertSame(values[2], ai.current());
		
		ai.next();
		assertFalse(ai.isDone());
		assertSame(values[3], ai.current());
		
		ai.next();
		assertTrue(ai.isDone());
		try{
			ai.current();
			fail();
		} catch (Exception ex) {
			// expected
		}	
	}
	
	public void testIterateBackwards() {
		String[] values = {"A", "B", "C"};
		ArrayIterator<String> ai = new ArrayIterator<>(values);
		
		ai.last();
		assertFalse(ai.isDone());
		assertSame(values[2], ai.current());
		
		ai.previous();
		assertFalse(ai.isDone());
		assertSame(values[1], ai.current());
		
		ai.previous();
		assertFalse(ai.isDone());
		assertSame(values[0], ai.current());
		
		ai.previous();
		assertTrue(ai.isDone());
		try{
			ai.current();
			fail();
		} catch (Exception ex) {
			// expected
		}
	}

}
