package com.wrox.algorithms.iteration;

import junit.framework.TestCase;

public class AlwaysDoneIteratorTest extends TestCase {

	String[] values = {"A", "B", "C"};
	
	public void testAnyIteration() {
		
		AlwaysDoneIterator<String> adi = new AlwaysDoneIterator<>(values);
		
		assertTrue(adi.isDone());
		
		try {
			adi.current();
			fail();
		} catch (Exception ex) {
			// expected
		}
	}
}
