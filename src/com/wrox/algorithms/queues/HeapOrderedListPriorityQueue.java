package com.wrox.algorithms.queues;

import com.wrox.algorithms.lists.ArrayList;
import com.wrox.algorithms.lists.List;
import com.wrox.algorithms.sorting.Comparator;

public class HeapOrderedListPriorityQueue<T extends Comparable<T>> implements Queue<T> {
	
	private List<T> list;
	
	private Comparator<T> comparator;
	
	public HeapOrderedListPriorityQueue(Comparator<T> comp) {
		comparator = comp;
		list = new ArrayList<>();
	}

	@Override
	public void enque(T value) {
		list.add(value);
		swim(list.size() - 1);
		
	}

	@Override
	public T dequeue() throws EmptyQueueException {
		if (list.isEmpty()) {
			throw new EmptyQueueException();
		}
		T result = list.get(0);
		if (list.size() > 1) {
			list.set(0, list.get(list.size() -1));
			sink(0);
		}
		list.delete(list.size() - 1);
		
		return result;
	}

	@Override
	public void clear() {
		list.clear();
	}

	@Override
	public int size() {
		return list.size();
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}
	
	private void swim(int index) {
		if (index == 0) {
			return;			
		}
		int parentIndex = getParentIndex(index);
		if (comparator.compare(list.get(index), list.get(parentIndex)) > 0) {
			swap(parentIndex, index);
			swim(parentIndex);
		}
	}
	
	private void swap(int leftIndex, int rightIndex) {
		T left = list.get(leftIndex);
		list.set(leftIndex, list.get(rightIndex));
		list.set(rightIndex, left);
	}
	
	private void sink(int index) {
		int leftChildIndex = getLeftChildIndex(index);
		int rightChildIndex = getRightChildIndex(index);
		
		
		// always fill left child, then right child;
		// if left child is not present, just return we have 
		// sunk to the correct spot
		if (leftChildIndex >= list.size()) {
			return; // no children
		}
		
		int largestChildIndex = leftChildIndex; // default to left
		if (rightChildIndex < list.size()) { // there is a right child; compare
			if (comparator.compare(list.get(leftChildIndex), list.get(rightChildIndex)) < 0) {
				largestChildIndex = rightChildIndex;
			}
		}
		
		// if our candidate sinker is less than the largest child, swap and sink again
		if (comparator.compare(list.get(index), list.get(largestChildIndex)) < 0) {
			swap(index, largestChildIndex);
			sink(largestChildIndex);
		}
 	}
	
	private int getLeftChildIndex(int index) {
		return (2 * index) + 1;
	}
	
	private int getRightChildIndex(int index) {
		return (2 * index) + 2;
	}
	
	private int getParentIndex(int index) {
		return (index - 1) / 2;
	}
}
