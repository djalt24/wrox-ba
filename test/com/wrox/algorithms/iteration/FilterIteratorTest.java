package com.wrox.algorithms.iteration;

import junit.framework.TestCase;

public class FilterIteratorTest extends TestCase {

	private static final String[] VALUES = {"A","B","C"};
	
	public void testForwardIterationIncludesItemsWhenPredicateReturnsTrue() {
		ArrayIterator<String> control = new ArrayIterator<>(VALUES);
		ArrayIterator<String> test = new ArrayIterator<>(VALUES);
		
		FilterIterator<String> fi = new FilterIterator<>(test, new DummyPredicate<String>(true, control));
		
		fi.first();
		assertFalse(fi.isDone());
		assertSame(fi.current(), VALUES[0]);
		
		fi.next();
		assertFalse(fi.isDone());
		assertSame(fi.current(), VALUES[1]);
		
		fi.next();
		assertFalse(fi.isDone());
		assertSame(fi.current(), VALUES[2]);
		
		fi.next();
		assertTrue(fi.isDone());
		try {
			fi.current();
			fail();
		} catch (Exception ex) {
			// expected
		}
		
		assertTrue(control.isDone());
		assertTrue(test.isDone());
	}
	
	public void testBackwardIterationIncludesItemsWhenPredicateReturnsTrue() {
		ArrayIterator<String> control = new ArrayIterator<>(VALUES);
		ArrayIterator<String> test = new ArrayIterator<>(VALUES);
		
		ReverseIterator<String> controlReverse = new ReverseIterator<>(control);
		ReverseIterator<String> testReverse = new ReverseIterator<>(test);
		
		FilterIterator<String> fi 
		   = new FilterIterator<>(testReverse, new DummyPredicate<String>(true, controlReverse));
		
		fi.first();
		assertFalse(fi.isDone());
		assertSame(fi.current(), VALUES[2]);
		
		fi.next();
		assertFalse(fi.isDone());
		assertSame(fi.current(), VALUES[1]);
		
		fi.next();
		assertFalse(fi.isDone());
		assertSame(fi.current(), VALUES[0]);
		
		fi.next();
		assertTrue(fi.isDone());
		try {
			fi.current();
			fail();
		} catch (Exception ex) {
			// expected
		}
		
		assertTrue(controlReverse.isDone());
		assertTrue(testReverse.isDone());
	}
	
	public void testForwardIterationExcludesItemsWhenPredicateReturnsFalse() {
		ArrayIterator<String> control = new ArrayIterator<>(VALUES);
		ArrayIterator<String> test = new ArrayIterator<>(VALUES);
		
		FilterIterator<String> fi = new FilterIterator<>(test, new DummyPredicate<String>(false, control));
		
		fi.first();
		assertTrue(fi.isDone());
		
		try {
			fi.current();
			fail();
		} catch (Exception ex) {
			// expected
		}
	}
	
	public void testBackwardIterationExcludesItemsWhenPredicateReturnsFalse() {
		ArrayIterator<String> control = new ArrayIterator<>(VALUES);
		ArrayIterator<String> test = new ArrayIterator<>(VALUES);
		
		ReverseIterator<String> controlReverse = new ReverseIterator<>(control);
		ReverseIterator<String> testReverse = new ReverseIterator<>(test);
		
		FilterIterator<String> fi 
		   = new FilterIterator<>(testReverse, new DummyPredicate<String>(false, controlReverse));
		
		fi.first();
		assertTrue(fi.isDone());
		
		try {
			fi.current();
			fail();
		} catch (Exception ex) {
			// expected
		}
	}

	private static final class DummyPredicate<T> implements Predicate {
		
		private final Iterator<T> wrapped;
		
		private final boolean value;
		
		public DummyPredicate(boolean result, Iterator<T> iterator) {
			value = result;
			wrapped     = iterator;
			wrapped.first();
		}

		@Override
		public boolean evaluate(Object o) {
			assertSame(wrapped.current(), o);
			wrapped.next();
			return value;
		}		
	}
}
