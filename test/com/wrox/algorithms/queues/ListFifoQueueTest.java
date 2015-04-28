package com.wrox.algorithms.queues;

import com.wrox.algorithms.lists.AbstractListTestCase;
import com.wrox.algorithms.lists.List;

public class ListFifoQueueTest extends AbstractFifoQueueTestCase<String> {
	
	private static final String VALUE_A = "A";
	
	private static final String VALUE_B = "B";
	
	private static final String VALUE_C = "C";
	
	public ListFifoQueueTest() {
		super(VALUE_A, VALUE_B, VALUE_C);
	}

	@Override
	protected Queue createFifoQueue() {
		return new ListFifoQueue<String>();
	}
}
