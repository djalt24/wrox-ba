package com.wrox.algorithms.sorting;


import java.util.Random;

import com.wrox.algorithms.iteration.Iterator;
import com.wrox.algorithms.lists.ArrayList;
import com.wrox.algorithms.lists.LinkedList;
import com.wrox.algorithms.lists.List;

import junit.framework.TestCase;

public abstract class AbstractListSorterTest extends TestCase {
	
	private static final int NUMBER_TEST_LIMIT = 15;

	List<String> unsortedList;
	List<String> sortedList;
	List<Double> randomDoubles = new ArrayList<>();
	
	private static final Random RANDOM = new Random();
	
	@Override
	protected void setUp() throws Exception {
		unsortedList = new LinkedList<String>();
		
		unsortedList.add("test");
		unsortedList.add("driven");
		unsortedList.add("development");
		unsortedList.add("is");
		unsortedList.add("one");
		unsortedList.add("small");
		unsortedList.add("step");
		unsortedList.add("for");
		unsortedList.add("a");
		unsortedList.add("programmer");
		unsortedList.add("but");
		unsortedList.add("it's");
		unsortedList.add("one");
		unsortedList.add("giant");
		unsortedList.add("leap");
		unsortedList.add("for");
		unsortedList.add("programming");
		
		sortedList = new LinkedList<String>();
		
		sortedList.add("a");
		sortedList.add("but");
		sortedList.add("development");
		sortedList.add("driven");
		sortedList.add("for");
		sortedList.add("for");
		sortedList.add("giant");
		sortedList.add("is");
		sortedList.add("it's");
		sortedList.add("leap");
		sortedList.add("one");
		sortedList.add("one");
		sortedList.add("programmer");
		sortedList.add("programming");
		
		for (int i = 0; i < NUMBER_TEST_LIMIT; i++) {
			randomDoubles.add(RANDOM.nextDouble());
		}
	}
	
	@Override
	protected void tearDown() throws Exception {
		unsortedList = null;
		sortedList = null;
	}
	
	public abstract ListSorter<String> createListSorter();
	
	public abstract ListSorter<Double> createDoubleListSorter();
	
	public void testListSorterCanSortSampleList() {
		ListSorter<String> sorter = createListSorter();
		List<String> sorted = sorter.sort(unsortedList);
		
		assertEquals(sorted.size(), unsortedList.size());
		
		Iterator<String> actual = sorted.iterator();
		actual.first();
		
		Iterator<String> expected = sortedList.iterator();
		expected.first();
		
		while (!expected.isDone()) {

			assertEquals(actual.current(), expected.current());
			
			actual.next();
			expected.next();
		}		
	}
	
	public void testHomeWorkProblem1() {
		ListSorter<Double> sorter = createDoubleListSorter();
		printList("UNSORTED", randomDoubles);
		List<Double> sorted = sorter.sort(randomDoubles);
		printList("SORTED", sorted);
		
	}
	
	private void printList(String name, List<?> list) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(name + " [");
		Iterator<?> iter = list.iterator();
		for (iter.first(); !iter.isDone(); iter.next()) {
			buffer.append(iter.current());
			buffer.append(",");
		}
		buffer.append("]");
		System.out.println(buffer.toString());
	}
}
