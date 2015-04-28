package com.wrox.algorithms.iteration;

import junit.framework.TestCase;

public class AndPredicateTest extends TestCase {
	
	String[] values = {"A", "B", "C"};
	
	public void testTrueTrue() {
		AndPredicate and = new AndPredicate(new TruePredicate(), new TruePredicate());
		
		ArrayIterator<String> iterator = new ArrayIterator<>(values);
		
		FilterIterator<String> filtered = new FilterIterator<>(iterator, and);
		
		filtered.first();
		assertFalse(filtered.isDone());
		assertEquals(filtered.current(), values[0]);
		
		filtered.next();
		assertFalse(filtered.isDone());
		assertEquals(filtered.current(), values[1]);
		
		filtered.next();
		assertFalse(filtered.isDone());
		assertEquals(filtered.current(), values[2]);
		
		filtered.next();
		assertTrue(filtered.isDone());
		try {
			filtered.current();
			fail();
		} catch (Exception ex) {
			// expected
		}
	}
	
	public void testTrueFalse() {
		AndPredicate and = new AndPredicate(new TruePredicate(), new FalsePredicate());
		
		ArrayIterator<String> iterator = new ArrayIterator<>(values);
		
		FilterIterator<String> filtered = new FilterIterator<>(iterator, and);
		
		filtered.first();
		assertTrue(filtered.isDone());
		try {
			filtered.current();
			fail();
		} catch (Exception ex) {
			// expected
		}
	}
	
	
	public class TruePredicate implements Predicate {

		@Override
		public boolean evaluate(Object o) {
			return true;
		}
	}
	
	public class FalsePredicate implements Predicate {

		@Override
		public boolean evaluate(Object o) {
			return false;
		}	
	}

}
