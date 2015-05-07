package com.wrox.algorithms.queues;

import com.wrox.algorithms.lists.LinkedList;
import com.wrox.algorithms.lists.List;
import com.wrox.algorithms.sorting.Comparator;
import com.wrox.algorithms.sorting.InsertionsortListSorter;
import com.wrox.algorithms.sorting.ListSorter;
import com.wrox.algorithms.sorting.SelectionsortListSorter;

public class SortedListPriorityQueue<T extends Comparable<T>> implements Queue<T>{
	
	private Comparator<T> comparator;
	
	private List<T> list = new LinkedList<>();
	
	private ListSorter<T> sorter;
	
	public SortedListPriorityQueue(Comparator<T> comp) {
		comparator = comp;
		
		sorter = new SelectionsortListSorter<>(comparator);
	}

	@Override
	public void enque(T value) {
		list.insert(0, value);
		sorter.sort(list);
	}

	@Override
	public T dequeue() throws EmptyQueueException {
		if (list.isEmpty()) {
			throw new EmptyQueueException();
		}
		return list.delete(list.size() - 1);
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

}
