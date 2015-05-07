package com.wrox.algorithms.queues;

import com.wrox.algorithms.lists.LinkedList;
import com.wrox.algorithms.lists.List;
import com.wrox.algorithms.sorting.BubblesortListSorter;
import com.wrox.algorithms.sorting.Comparator;
import com.wrox.algorithms.sorting.ListSorter;

public class UnsortedListPriorityQueue<T extends Comparable<T>> implements Queue<T> {
	
	List<T> list = new LinkedList<>();
	
	Comparator<T> comparator;
	
	ListSorter<T> sorter;
	
	public UnsortedListPriorityQueue(Comparator<T> comp) {
		comparator = comp;
		sorter = new BubblesortListSorter<>(comp);
	}

	@Override
	public void enque(T value) {
		list.add(value);
	}

	@Override
	public T dequeue() throws EmptyQueueException {
		if (list.isEmpty()) {
			throw new EmptyQueueException();
		}
		sorter.sort(list);
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
