package com.wrox.algorithms.lists;


import com.wrox.algorithms.iteration.Iterator;

import junit.framework.TestCase;

public abstract class AbstractListTestCase<T> extends TestCase {
	
	private final T myValueA;
	
	private final T myValueB;
	
	private final T myValueC;
	
	public AbstractListTestCase(T valueA, T valueB, T valueC ) {
		myValueA = valueA;
		myValueB = valueB;
		myValueC = valueC;
	}
	
	// testing a list interface can be broken into five separate categories
	// 1. insert
	// 2. get/set
	// 3. delete
	// 4. iterate/find
	// 5. clear
	//
	// each category has a number of tests, let's write them now
	
	// insertion test
	public void testInsertIntoEmptyList() {
		List<T> myList = getList();
		
		assertEquals(0, myList.size());
		assertTrue(myList.isEmpty());
		
		myList.insert(0,  myValueA);
		
		assertEquals(1, myList.size());
		assertFalse(myList.isEmpty());
		assertSame(myList.get(0), myValueA);		
	}
	
	// insertion test
	public void testInsertBetweenElements() {
		List<T> myList = getList();
		
		myList.insert(0, myValueA);
		myList.insert(1, myValueB);
		myList.insert(1, myValueC);
		
		assertSame(myList.get(0), myValueA);
		assertSame(myList.get(1), myValueC);
		assertSame(myList.get(2), myValueB);
		
		assertEquals(3, myList.size());
	}
	
	// insertion test
	public void testInsertBeforeFirst() {
		List<T> myList = getList();
		
		myList.insert(0, myValueA);
		myList.insert(0, myValueB);
		
		assertSame(myList.get(0), myValueB);
		assertSame(myList.get(1), myValueA);
		
		assertEquals(2, myList.size());
	}
	
	// insertion test
	public void testInsertAfterLast() {
		List<T> myList = getList();
		
		myList.insert(0, myValueA);
		myList.insert(1, myValueB);
		
		assertSame(myList.get(0), myValueA);
		assertSame(myList.get(1), myValueB);
		
		assertEquals(2, myList.size());
	}
	
	// insertion test
	public void testInsertOutOfBounds() {
		List<T> myList = getList();
		
		try {
			myList.insert(-1, myValueA);
			fail();
		} catch (Exception Ex) {
			// expected
		}
		
		try {
			myList.insert(1, myValueA);
			fail();
		} catch (Exception Ex) {
			// expected
		}
	}
	
	// insertion test
	public void testAdd() {
		List<T> myList = getList();
		
		myList.add(myValueA);
		myList.add(myValueB);
		myList.add(myValueC);
		
		assertSame(myList.get(0), myValueA);
		assertSame(myList.get(1), myValueB);
		assertSame(myList.get(2), myValueC);
		
		assertEquals(3, myList.size());
	}
	
	// get/set test
	public void testSet() {
		List<T> myList = getList();
		
		myList.insert(0, myValueA);
		assertSame(myList.get(0), myValueA);
		
		myList.set(0, myValueB);
		assertSame(myList.get(0), myValueB);
	}
	
	// get/set test
	public void testGetOutOfBounds() {
		List<T> myList = getList();
		
		try {
			myList.get(-1);
			fail();
		} catch(Exception ex) {
			// expected
		}
		
		try {
			myList.get(0);
			fail();
		} catch(Exception ex) {
			// expected
		}
		
		myList.add(myValueA);
		
		try {
			myList.get(1);
			fail();
		} catch(Exception ex) {
			// expected
		}
	}
	
	// get/set test
	public void testSetOutOfBounds() {
		List<T> myList = getList();
		
		try {
			myList.set(-1, myValueA);
			fail();
		} catch(Exception ex) {
			// expected
		}
		
		try {
			myList.set(0, myValueA);
			fail();
		} catch(Exception ex) {
			// expected
		}
		
		myList.insert(0, myValueA);
		
		try {
			myList.set(1, myValueA);
			fail();
		} catch(Exception ex) {
			// expected
		}
	}
	
	// delete test
	public void testDeleteOnlyElement() {
		List<T> myList = getList();
		
		myList.insert(0, myValueA);
		assertSame(myList.get(0), myValueA);
		assertSame(myList.size(), 1);
		
		Object deleted = myList.delete(0);
		assertSame(myList.size(), 0);
		assertSame(myValueA, deleted);
	}
	
	// delete test
	public void testDeleteFirstElement() {
		List<T> myList = getList();
		
		myList.add(myValueA);
		myList.add(myValueB);
		myList.add(myValueC);
		
		assertSame(3, myList.size());
		
		assertSame(myValueA, myList.get(0));
		assertSame(myValueB, myList.get(1));
		assertSame(myValueC, myList.get(2));
		
		Object deleted = myList.delete(0);
		assertSame(myValueA, deleted);
		assertSame(myValueB, myList.get(0));
		assertSame(myValueC, myList.get(1));
	}
	
	// delete test
	public void testDeleteLastElement() {
		List<T> myList = getList();
		
		myList.add(myValueA);
		myList.add(myValueB);
		myList.add(myValueC);
		
		assertSame(3, myList.size());
		
		assertSame(myValueA, myList.get(0));
		assertSame(myValueB, myList.get(1));
		assertSame(myValueC, myList.get(2));
		
		Object deleted = myList.delete(2);
		assertSame(myValueC, deleted);
		assertSame(myValueA, myList.get(0));
		assertSame(myValueB, myList.get(1));
	}
	
	// delete test
	public void testDeleteMiddleElement() {
		List<T> myList = getList();
		
		myList.add(myValueA);
		myList.add(myValueB);
		myList.add(myValueC);
		
		assertSame(3, myList.size());
		
		assertSame(myValueA, myList.get(0));
		assertSame(myValueB, myList.get(1));
		assertSame(myValueC, myList.get(2));
		
		Object deleted = myList.delete(1);
		assertSame(myValueB, deleted);
		assertSame(myValueA, myList.get(0));
		assertSame(myValueC, myList.get(1));
	}
	
	// delete test
	public void testDeleteOutOfBounds() {
		List<T> myList = getList();
		
		myList.add(myValueA);
		myList.add(myValueB);
		myList.add(myValueC);
		
		assertSame(3, myList.size());
		
		try {
			myList.delete(3);
			fail();
		} catch (Exception ex) {
			// expected
		}
	}
	
	// delete test
	public void testDeleteByValue() {
		List<T> myList = getList();
		
		myList.add(myValueA);
		myList.add(myValueB);
		myList.add(myValueC);
		
		assertSame(3, myList.size());
		
		assertSame(myValueA, myList.get(0));
		assertSame(myValueB, myList.get(1));
		assertSame(myValueC, myList.get(2));
		
		assertTrue(myList.delete(myValueB));
		assertSame(myValueA, myList.get(0));
		assertSame(myValueC, myList.get(1));
	}
	
	// iterate/find test
	public void testIterateEmptyList() {
		List<T> myList = getList();
		Iterator<T> iter = myList.iterator();
		
		iter.next();
		assertTrue(iter.isDone());
		
		try {
			iter.current();
			fail();
		} catch (Exception ex) {
			// expected
		}
	}
	
	// iterate/find test
	public void testIterateForwards() {
		List<T> myList = getList();
		
		myList.add(myValueA);
		myList.add(myValueB);
		myList.add(myValueC);
		
		assertSame(3, myList.size());
		
		Iterator<T> iter = myList.iterator();
		
		iter.first();
		assertSame(myValueA, iter.current());
		assertFalse(iter.isDone());
		
		iter.next();
		assertSame(myValueB, iter.current());
		assertFalse(iter.isDone());
		
		iter.next();
		assertSame(myValueC, iter.current());
		assertFalse(iter.isDone());
		
		iter.next();
		assertTrue(iter.isDone());
		
		try {
			iter.current();
			fail();
		} catch(Exception ex) {
			// expected
		}
	
	}
	
	// iterate/find test
	public void testIterateBackwards() {
		List<T> myList = getList();
		
		myList.add(myValueA);
		myList.add(myValueB);
		myList.add(myValueC);
		
		assertSame(3, myList.size());
		
		Iterator<T> iter = myList.iterator();
		
		iter.last();
		assertSame(myValueC, iter.current());
		assertFalse(iter.isDone());
		
		iter.previous();
		assertSame(myValueB, iter.current());
		assertFalse(iter.isDone());
		
		iter.previous();
		assertSame(myValueA, iter.current());
		assertFalse(iter.isDone());
		
		iter.previous();
		assertTrue(iter.isDone());
		
		try {
			iter.current();
			fail();
		} catch(Exception ex) {
			// expected
		}
	}
	
	// iterate/find test
	public void testIndexOf() {
		List<T> myList = getList();
		
		myList.add(myValueA);
		myList.add(myValueB);
		myList.add(myValueC);
		
		assertSame(0, myList.indexOf(myValueA));
		assertSame(1, myList.indexOf(myValueB));
		assertSame(2, myList.indexOf(myValueC));
	}
	
	// iterate/find test
	public void testContains() {
		List<T> myList = getList();
		
		myList.add(myValueA);
		myList.add(myValueC);
		
		assertTrue(myList.contains(myValueA));
		assertFalse(myList.contains(myValueB));
		assertTrue(myList.contains(myValueC));
	}
	
	// clear test
	public void testClear() {
		List<T> myList = getList();
		
		myList.add(myValueA);
		myList.add(myValueB);
		myList.add(myValueC);
		
		assertFalse(myList.isEmpty());
		assertSame(3, myList.size());
		
		myList.clear();
		
		assertTrue(myList.isEmpty());
		assertSame(0, myList.size());
	}
		
	public abstract List<T> getList();
	
}
