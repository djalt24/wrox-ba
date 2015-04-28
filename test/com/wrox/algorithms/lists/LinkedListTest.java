package com.wrox.algorithms.lists;

public class LinkedListTest extends AbstractListTestCase<String> {
	
	private static final String VALUE_A = "A";
	
	private static final String VALUE_B = "B";
	
	private static final String VALUE_C = "C";
	
	public LinkedListTest() {
		super(VALUE_A, VALUE_B, VALUE_C);
	}

	@Override
	public List<String> getList() {
		return new LinkedList<String>();
	}
}
