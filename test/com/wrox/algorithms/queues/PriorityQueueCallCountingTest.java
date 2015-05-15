package com.wrox.algorithms.queues;

import junit.framework.TestCase;

import com.wrox.algorithms.iteration.Iterator;
import com.wrox.algorithms.lists.ArrayList;
import com.wrox.algorithms.lists.List;
import com.wrox.algorithms.sorting.CallCountingListComparator;
import com.wrox.algorithms.sorting.Comparator;
import com.wrox.algorithms.sorting.NaturalComparator;

public class PriorityQueueCallCountingTest extends TestCase {

	private static final int TEST_SIZE = 1000; 
	
	private List<Integer> sortedList = new ArrayList<>();
	
	private List<Integer> unsortedList = new ArrayList<>();
	
	private List<Integer> reverseList = new ArrayList<>();
	
	CallCountingListComparator<Integer> comparator;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		
		comparator = new CallCountingListComparator<Integer>(new NaturalComparator<Integer>());
		
		for (int i = 1; i < TEST_SIZE; i++) {
			sortedList.add(i);
		}
		
		for (int i = 1; i < TEST_SIZE; i++) {
			unsortedList.add(new Integer((int)(TEST_SIZE * Math.random())));
		}
		
		for (int i = TEST_SIZE; i > 0; i--) {
			reverseList.add(i);
		}
	}
	
	public void testWorstCaseUnsortedList() {
		runScenario(new UnsortedListPriorityQueue<Integer>(comparator), reverseList);
	}
	
	public void testWorstCaseSortedList() {
		runScenario(new SortedListPriorityQueue<Integer>(comparator), reverseList);
	}
	
	public void testWorstCaseHeapOrderedList() {
		runScenario(new HeapOrderedListPriorityQueue<Integer>(comparator), reverseList);
	}
	
	public void testBestCaseUnsortedList() {
		runScenario(new UnsortedListPriorityQueue<Integer>(comparator), sortedList);
	}
	
	public void testBestCaseSortedList() {
		runScenario(new SortedListPriorityQueue<Integer>(comparator), sortedList);
	}
	
	public void testBestCaseHeapOrderedList() {
		runScenario(new HeapOrderedListPriorityQueue<Integer>(comparator), sortedList);
	}
	
	public void testAverageCaseUnsortedList() {
		runScenario(new UnsortedListPriorityQueue<Integer>(comparator), unsortedList);
	}
	
	public void testAverageCaseSortedList() {
		runScenario(new SortedListPriorityQueue<Integer>(comparator), unsortedList);
	}
	
	public void testAverageCaseHeapOrderedList() {
		runScenario(new HeapOrderedListPriorityQueue<Integer>(comparator), unsortedList);
	}
	
	private void runScenario(Queue<Integer> queue, List<Integer> list) {
		for (int i = 1; i < list.size(); i++) {
			queue.enque(list.get(i));
			if (i % 100 == 0) {
				for (int j = 0; j < 25; j++) {
					queue.dequeue();
				}
			}
		}
		
		while (!queue.isEmpty()) {
			queue.dequeue();
		}
		
		reportCalls();
	}
	
	private void reportCalls() {
		int callCount = comparator.getCount();
		System.out.println(getName() + ": " + callCount + " calls");
	}

}
