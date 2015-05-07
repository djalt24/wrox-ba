package com.wrox.algorithms.queues;

import com.wrox.algorithms.sorting.Comparator;

public class SortedListPriorityQueueTest extends AbstractPriorityQueueTestCase<String> {

	private static final String SMALLEST = "A";
	
	private static final String VALUE_B = "B";
	
	private static final String VALUE_C = "C";
	
	private static final String VALUE_D = "D";
	
	private static final String LARGEST = "E";
	
	public SortedListPriorityQueueTest() {
		super(SMALLEST, VALUE_B, VALUE_C, VALUE_D, LARGEST);
	}

	@Override
	protected Queue<String> createQueue(Comparator<String> comparator) {
		return new SortedListPriorityQueue<>(comparator);
	}

}
