package com.wrox.algorithms.sorting;

import java.util.Random;

import com.wrox.algorithms.lists.ArrayList;
import com.wrox.algorithms.lists.List;

import junit.framework.TestCase;

public class CallCountingListSorterTest extends TestCase {

	private static final int TEST_SIZE = 1000;
	
	private List<Integer> sortedArrayList = new ArrayList<>();
	
	private List<Integer> reverseArrayList = new ArrayList<>();
	
	private List<Integer> randomArrayList = new ArrayList<>();
	
	private static final Random RANDOM = new Random();
	
	private static final CallCountingListComparator<Integer> NATURAL_COUNTING_COMPARATOR
	  = new CallCountingListComparator<>(new NaturalComparator<Integer>());
	
	@Override
	protected void setUp() throws Exception {
		// sorted
		for (int i = 1; i < TEST_SIZE; i++) {
			sortedArrayList.add(i);
		}
		
		// reverse
		for (int i = TEST_SIZE; i > 0; i--) {
			reverseArrayList.add(i);
		}
		
		// random
		for (int i = 1; i < TEST_SIZE; i++) {
			randomArrayList.add(RANDOM.nextInt(TEST_SIZE));
		}
	}
	
	public void testWorstBubbleSort() {
		NATURAL_COUNTING_COMPARATOR.resetCount();
		BubblesortListSorter<Integer> sorter
		   = new BubblesortListSorter<>(NATURAL_COUNTING_COMPARATOR);
		sorter.sort(reverseArrayList);
		System.out.println("WBB=" + NATURAL_COUNTING_COMPARATOR.getCount());
	}
	
	public void testWorstSelectionSort() {
		NATURAL_COUNTING_COMPARATOR.resetCount();
		SelectionsortListSorter<Integer> sorter
		   = new SelectionsortListSorter<>(NATURAL_COUNTING_COMPARATOR);
		sorter.sort(reverseArrayList);
		System.out.println("WSEL=" + NATURAL_COUNTING_COMPARATOR.getCount());
	}
	
	public void testWorstInsertionSort() {
		NATURAL_COUNTING_COMPARATOR.resetCount();
		InsertionsortListSorter<Integer> sorter
		   = new InsertionsortListSorter<>(NATURAL_COUNTING_COMPARATOR);
		sorter.sort(reverseArrayList);
		System.out.println("WINS=" + NATURAL_COUNTING_COMPARATOR.getCount());
	}
	
	public void testBestBubbleSort() {
		NATURAL_COUNTING_COMPARATOR.resetCount();
		BubblesortListSorter<Integer> sorter
		   = new BubblesortListSorter<>(NATURAL_COUNTING_COMPARATOR);
		sorter.sort(sortedArrayList);
		System.out.println("BBB=" + NATURAL_COUNTING_COMPARATOR.getCount());
	}
	
	public void testBestSelectionSort() {
		NATURAL_COUNTING_COMPARATOR.resetCount();
		SelectionsortListSorter<Integer> sorter
		   = new SelectionsortListSorter<>(NATURAL_COUNTING_COMPARATOR);
		sorter.sort(sortedArrayList);
		System.out.println("BSEL=" + NATURAL_COUNTING_COMPARATOR.getCount());
	}
	
	public void testBestInsertionSort() {
		NATURAL_COUNTING_COMPARATOR.resetCount();
		InsertionsortListSorter<Integer> sorter
		   = new InsertionsortListSorter<>(NATURAL_COUNTING_COMPARATOR);
		sorter.sort(sortedArrayList);
		System.out.println("BINS=" + NATURAL_COUNTING_COMPARATOR.getCount());
	}	
	
	public void testAverageBubbleSort() {
		NATURAL_COUNTING_COMPARATOR.resetCount();
		BubblesortListSorter<Integer> sorter
		   = new BubblesortListSorter<>(NATURAL_COUNTING_COMPARATOR);
		sorter.sort(randomArrayList);
		System.out.println("ABB=" + NATURAL_COUNTING_COMPARATOR.getCount());
	}
	
	public void testAverageSelectionSort() {
		NATURAL_COUNTING_COMPARATOR.resetCount();
		SelectionsortListSorter<Integer> sorter
		   = new SelectionsortListSorter<>(NATURAL_COUNTING_COMPARATOR);
		sorter.sort(randomArrayList);
		System.out.println("ASEL" + NATURAL_COUNTING_COMPARATOR.getCount());
	}
	
	public void testAverageInsertionSort() {
		NATURAL_COUNTING_COMPARATOR.resetCount();
		InsertionsortListSorter<Integer> sorter
		   = new InsertionsortListSorter<>(NATURAL_COUNTING_COMPARATOR);
		sorter.sort(randomArrayList);
		System.out.println("AINS=" + NATURAL_COUNTING_COMPARATOR.getCount());
	}
}
