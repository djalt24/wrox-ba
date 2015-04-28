package com.wrox.algorithms.stacks;

import com.wrox.algorithms.lists.AbstractListTestCase;
import com.wrox.algorithms.lists.ArrayList;
import com.wrox.algorithms.lists.List;

public class UndoableListTestCase extends AbstractListTestCase<String> {
	
	private static final String VALUE_A = "A";
	
	private static final String VALUE_B = "B";
	
	private static final String VALUE_C = "C";
	
	public UndoableListTestCase() {
		super(VALUE_A, VALUE_B, VALUE_C);
	}

	@Override
	public List<String> getList() {
		return new UndoableList<String>(new ArrayList<>());
	}
	
	public void testUndoInsert() {
		UndoableList<String> list = (UndoableList<String>)getList();
		
		list.insert(0, VALUE_A);
		list.insert(1, VALUE_C);
		list.insert(1, VALUE_B);
		
		assertEquals(VALUE_A, list.get(0));
		assertEquals(VALUE_B, list.get(1));
		assertEquals(VALUE_C, list.get(2));
		assertTrue(list.canUndo());
		
		list.undo();
		
		assertEquals(VALUE_A, list.get(0));
		assertEquals(VALUE_C, list.get(1));		
	}
	
	public void testUndoAdd() {
		UndoableList<String> list = (UndoableList<String>)getList();
		
		list.add(VALUE_B); // oops
		assertTrue(list.canUndo());
		
		list.undo();
		assertTrue(list.isEmpty());
		assertFalse(list.canUndo());
		
		try {
			list.undo();
			fail();
			
		} catch (Exception ex) {
			// expected
		}
	}
	
	public void testUndoDeleteByPosition() {
		UndoableList<String> list = (UndoableList<String>)getList();
		
		list.add(VALUE_A);
		assertEquals(VALUE_A, list.get(0));
		assertTrue(list.canUndo());
		
		list.delete(0);
		assertTrue(list.isEmpty());
		assertTrue(list.canUndo());
		
		list.undo();
		assertEquals(VALUE_A, list.get(0));
		assertTrue(list.canUndo());
		
		list.undo();
		assertTrue(list.isEmpty());
		assertFalse(list.canUndo());
		
		try {
			list.undo();
			fail();
			
		} catch (Exception ex) {
			// expected
		}
	}
	
	public void testUndoDeleteByValue() {
		UndoableList<String> list = (UndoableList<String>)getList();
		
		list.add(VALUE_A);
		assertEquals(VALUE_A, list.get(0));
		assertTrue(list.canUndo());
		
		list.delete(VALUE_A);
		assertTrue(list.isEmpty());
		assertTrue(list.canUndo());
		
		list.undo();
		assertEquals(VALUE_A, list.get(0));
		assertTrue(list.canUndo());
		
		list.undo();
		assertTrue(list.isEmpty());
		assertFalse(list.canUndo());
		
		try {
			list.undo();
			fail();
			
		} catch (Exception ex) {
			// expected
		}
	}
	
	public void testUndoSet() {
		UndoableList<String> list = (UndoableList<String>)getList();
		
		list.add(VALUE_A);
		assertEquals(VALUE_A, list.get(0));
		assertTrue(list.canUndo());
		
		list.set(0,  VALUE_B);
		assertEquals(VALUE_B, list.get(0));
		assertTrue(list.canUndo());
		
		list.undo();
		assertEquals(VALUE_A, list.get(0));
		assertTrue(list.canUndo());
		
		list.undo();
		assertTrue(list.isEmpty());
		assertFalse(list.canUndo());
		
		try {
			list.undo();
			fail();
			
		} catch (Exception ex) {
			// expected
		}
	}
	
	public void testClearResetsUndoStack() {
		UndoableList<String> list = (UndoableList<String>)getList();
		
		assertFalse(list.canUndo());
		
		list.add(VALUE_A);
		assertTrue(list.canUndo());
		
		list.clear();
		assertFalse(list.canUndo());
	}
	
	public void testUndoMultiple() {
		UndoableList<String> list = (UndoableList<String>)getList();
		
		list.add(VALUE_A);
		list.add(VALUE_B);
		list.add(VALUE_C);
		
		assertEquals(list.size(), 3);
		assertTrue(list.canUndo());
		
		list.undo();
		
		assertEquals(list.size(), 2);
		assertTrue(list.canUndo());
		
		list.undo();
		
		assertEquals(VALUE_A, list.get(0));
		assertEquals(list.size(), 1);
		assertTrue(list.canUndo());
		
		list.undo();
		assertTrue(list.isEmpty());
		assertFalse(list.canUndo());
		
		try {
			list.undo();
			fail();
			
		} catch (Exception ex) {
			// expected
		}
	}
}
