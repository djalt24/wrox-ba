package com.wrox.algorithms.stacks;

public class ListStackTest extends AbstractStackTestCase<String> {
	
	private static final String VALUE_A = "A";
	
	private static final String VALUE_B = "A";
	
	private static final String VALUE_C = "A";
	
	public ListStackTest() {
		super(VALUE_A, VALUE_B, VALUE_C);
	}

	@Override
	protected Stack createStack() {
		return new ListStack();
	}
}
