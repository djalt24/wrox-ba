package com.wrox.algorithms.sorting;

public class CallCountingListComparator<T extends Comparable<T>> implements Comparator<T> {
	
	private final Comparator<T> wrapped;
	
	int count = 0;
	
	public CallCountingListComparator(Comparator<T> wrap) {
		wrapped = wrap;
	}

	@Override
	public int compare(T left, T right) {		
		count++;
		return wrapped.compare(left, right);
		
	}
	
	public int getCount() {
		return count;
	}
	
	public void resetCount() {
		count = 0;
	}

}
