package com.wrox.algorithms.iteration;

import junit.framework.TestCase;

public class NthArrayIteratorTest extends TestCase {
	
	public String[] TEST_VALUES = {"0","1","2","3","4","5","6","7","8","9","10","11","12"};

	public void testEveryTwoForwards() {
		NthArrayIterator<String> iterator = new NthArrayIterator<>(TEST_VALUES, 2);
		
		iterator.first();
		assertFalse(iterator.isDone());
		assertEquals(TEST_VALUES[0], iterator.current());
		
		iterator.next();
		assertFalse(iterator.isDone());
		assertEquals(TEST_VALUES[2], iterator.current());
		
		iterator.next();
		assertFalse(iterator.isDone());
		assertEquals(TEST_VALUES[4], iterator.current());
		
		iterator.next();
		assertFalse(iterator.isDone());
		assertEquals(TEST_VALUES[6], iterator.current());
		
		iterator.next();
		assertFalse(iterator.isDone());
		assertEquals(TEST_VALUES[8], iterator.current());
		
		iterator.next();
		assertFalse(iterator.isDone());
		assertEquals(TEST_VALUES[10], iterator.current());
		
		iterator.next();
		assertFalse(iterator.isDone());
		assertEquals(TEST_VALUES[12], iterator.current());
		
		iterator.next();
		assertTrue(iterator.isDone());
		try {
			iterator.current();
			fail();
		} catch (Exception ex) {
			// expected
		}
	}
	
	public void testEveryTwoBackwards() {
		NthArrayIterator<String> iterator = new NthArrayIterator<>(TEST_VALUES, 2);
		
		iterator.last();
		assertFalse(iterator.isDone());
		assertEquals(TEST_VALUES[12], iterator.current());
		
		iterator.previous();
		assertFalse(iterator.isDone());
		assertEquals(TEST_VALUES[10], iterator.current());
		
		iterator.previous();
		assertFalse(iterator.isDone());
		assertEquals(TEST_VALUES[8], iterator.current());
		
		iterator.previous();
		assertFalse(iterator.isDone());
		assertEquals(TEST_VALUES[6], iterator.current());
		
		iterator.previous();
		assertFalse(iterator.isDone());
		assertEquals(TEST_VALUES[4], iterator.current());
		
		iterator.previous();
		assertFalse(iterator.isDone());
		assertEquals(TEST_VALUES[2], iterator.current());
		
		iterator.previous();
		assertFalse(iterator.isDone());
		assertEquals(TEST_VALUES[0], iterator.current());
		
		iterator.previous();
		assertTrue(iterator.isDone());
		try {
			iterator.current();
			fail();
		} catch (Exception ex) {
			// expected
		}
	}
	
	public void testEveryThreeForwards() {
		NthArrayIterator<String> iterator = new NthArrayIterator<>(TEST_VALUES, 3);
		
		iterator.first();
		assertFalse(iterator.isDone());
		assertEquals(TEST_VALUES[0], iterator.current());
		
		iterator.next();
		assertFalse(iterator.isDone());
		assertEquals(TEST_VALUES[3], iterator.current());
		
		iterator.next();
		assertFalse(iterator.isDone());
		assertEquals(TEST_VALUES[6], iterator.current());
		
		iterator.next();
		assertFalse(iterator.isDone());
		assertEquals(TEST_VALUES[9], iterator.current());
		
		iterator.next();
		assertFalse(iterator.isDone());
		assertEquals(TEST_VALUES[12], iterator.current());
		
		iterator.next();
		assertTrue(iterator.isDone());
		try {
			iterator.current();
			fail();
		} catch (Exception ex) {
			// expected
		}
	}
	
	public void testEveryThreeBackwards() {
		NthArrayIterator<String> iterator = new NthArrayIterator<>(TEST_VALUES, 3);
		
		iterator.last();
		assertFalse(iterator.isDone());
		assertEquals(TEST_VALUES[12], iterator.current());
		
		iterator.previous();
		assertFalse(iterator.isDone());
		assertEquals(TEST_VALUES[9], iterator.current());
		
		iterator.previous();
		assertFalse(iterator.isDone());
		assertEquals(TEST_VALUES[6], iterator.current());
		
		iterator.previous();
		assertFalse(iterator.isDone());
		assertEquals(TEST_VALUES[3], iterator.current());
		
		iterator.previous();
		assertFalse(iterator.isDone());
		assertEquals(TEST_VALUES[0], iterator.current());
		
		iterator.previous();
		assertTrue(iterator.isDone());
		try {
			iterator.current();
			fail();
		} catch (Exception ex) {
			// expected
		}
	}
}
