package com.wrox.algorithms.stacks;

import com.wrox.algorithms.iteration.Iterator;
import com.wrox.algorithms.lists.List;

public class UndoableList<T> implements List<T> {
	
	private Stack<UndoAction<T>> stack = new ListStack<UndoAction<T>>();
	
	private List<T> internal;
	
	private enum ActionType {ADD, INSERT, DELETE, SET, CLEAR};
	
	public UndoableList(List<T> wrapped) {
		internal = wrapped;		
	}

	@Override
	public Iterator<T> iterator() {
		return internal.iterator();
	}

	@Override
	public void insert(int index, T value) throws IndexOutOfBoundsException {
		internal.insert(index, value);
		UndoAction inserted = new UndoAction<T>(ActionType.INSERT, value, index);
		stack.push(inserted);		
	}

	@Override
	public T get(int index) throws IndexOutOfBoundsException {
		return internal.get(index);
	}

	@Override
	public T delete(int index) throws IndexOutOfBoundsException {
		T rv = internal.delete(index);
		UndoAction deleted = new UndoAction<T>(ActionType.DELETE, rv, index);
		stack.push(deleted);
		return rv;
	}

	@Override
	public int size() {
		return internal.size();
	}

	@Override
	public T set(int index, T value) throws IndexOutOfBoundsException {
		T saved = get(index);
		T rv = internal.set(index, value);
		UndoAction set = new UndoAction<T>(ActionType.SET, saved, index);
		stack.push(set);
		return rv;
	}

	@Override
	public void add(T value) {
		internal.add(value);
		UndoAction undoAdd = new UndoAction<T>(ActionType.ADD, value, internal.size() - 1);
		stack.push(undoAdd);
	}

	@Override
	public boolean delete(T value) {
		int index = indexOf(value);
		boolean success = internal.delete(value);
		if (success) {
			UndoAction deleted = new UndoAction<T>(ActionType.DELETE, value, index);
			stack.push(deleted);
		}		
		return success;
	}

	@Override
	public boolean contains(T value) {
		return internal.contains(value);
	}

	@Override
	public boolean isEmpty() {
		return internal.isEmpty();
	}

	@Override
	public void clear() {
		internal.clear();
		stack.clear();
	}
	
	public void undo() {
		UndoAction<T> undoMe = stack.pop();
		if (undoMe.type == ActionType.ADD) {
			// remove the object
			internal.delete(undoMe.value);
		} else if (undoMe.type == ActionType.DELETE) {
			// put back at index
			internal.insert(undoMe.index, undoMe.value);
		} else if (undoMe.type == ActionType.INSERT) {
			// just remove
			internal.delete(undoMe.index);
		} else if (undoMe.type == ActionType.SET) {
			// put back the old value
			internal.set(undoMe.index, undoMe.value);
		} else if (undoMe.type == ActionType.CLEAR) {
			// put back all the cleared values
			internal = undoMe.cleared;
		}		
	}
	
	public boolean canUndo() {
		return !stack.isEmpty();
	}
	
	private class UndoAction<T> {
		private ActionType type;
		private T value;
		private int index;
		private List<T> cleared;
		
		public UndoAction(ActionType a, T v, int idx) {
			type = a;
			value = v;
			index = idx;
		}
		public UndoAction(List<T> values) {
			cleared = values;
		}
	}

}
