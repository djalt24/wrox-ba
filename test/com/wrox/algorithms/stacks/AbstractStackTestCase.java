package com.wrox.algorithms.stacks;

import junit.framework.TestCase;

public abstract class AbstractStackTestCase<T> extends TestCase {
	
	private final T valueA;
	
	private final T valueB;
	
	private final T valueC;
	
	public AbstractStackTestCase(T valA, T valB, T valC) {
		valueA = valA;
		valueB = valB;
		valueC = valC;
	}
	
	protected abstract Stack createStack();
	
	public void testPushAndPop() {
		Stack stack = createStack();
		
		stack.push(valueA);
		stack.push(valueB);
		stack.push(valueC);
		assertFalse(stack.isEmpty());
		assertEquals(stack.size(), 3);
		
		assertEquals(valueC, stack.pop());
		assertFalse(stack.isEmpty());
		assertEquals(stack.size(), 2);
		
		assertEquals(valueB, stack.pop());
		assertFalse(stack.isEmpty());
		assertEquals(stack.size(), 1);
		
		assertEquals(valueA, stack.pop());
		assertTrue(stack.isEmpty());
		assertEquals(stack.size(), 0);
		
		try {
			Object val = stack.pop();
			fail();
		} catch (Exception ex) {
			//expected
		}
	}
	
	public void testPeek() {
		Stack stack = createStack();
		
		stack.push(valueA);
		stack.push(valueB);
		stack.push(valueC);
		assertFalse(stack.isEmpty());
		assertEquals(stack.size(), 3);
		
		assertEquals(valueC, stack.peek());
		assertFalse(stack.isEmpty());
		assertEquals(stack.size(), 3);
		
		assertEquals(valueC, stack.pop());
		assertFalse(stack.isEmpty());
		assertEquals(stack.size(), 2);
		
		assertEquals(valueB, stack.peek());
		assertFalse(stack.isEmpty());
		assertEquals(stack.size(), 2);
		
		assertEquals(valueB, stack.pop());
		assertFalse(stack.isEmpty());
		assertEquals(stack.size(), 1);
		
		assertEquals(valueA, stack.peek());
		assertFalse(stack.isEmpty());
		assertEquals(stack.size(), 1);
		
		assertEquals(valueA, stack.pop());
		assertTrue(stack.isEmpty());
		assertEquals(stack.size(), 0);
		
		try {
			Object val = stack.peek();
			fail();
		} catch (Exception ex) {
			//expected
		}
	}
	
	public void testClear() {
		Stack stack = createStack();
		
		stack.push(valueA);
		stack.push(valueB);
		stack.push(valueC);
		assertFalse(stack.isEmpty());
		assertEquals(stack.size(), 3);
		
		stack.clear();
		assertTrue(stack.isEmpty());
		assertEquals(stack.size(), 0);
		
		try {
			Object val = stack.peek();
			fail();
		} catch (Exception ex) {
			//expected
		}
	}
}
