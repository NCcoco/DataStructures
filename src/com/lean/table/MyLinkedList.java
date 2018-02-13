package com.lean.table;

import java.util.Collection;
import java.util.Iterator;

public class MyLinkedList<T> implements Collection<T>, Iterable<T>, java.io.Serializable {
	private static final long serialVersionUID = -8700012417418905045L;
	
	
	private Entry<T> header = new Entry<>(null, null, null);
	private int size = 0;
	
	public MyLinkedList(){
		
	}
	

	@Override
	public boolean add(T e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends T> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private static class Entry<T> {
		T element;
		Entry<T> next;
		Entry<T> prev;
		public Entry(T element, Entry<T> next, Entry<T> prev) {
			this.element = element;
			this.next = next;
			this.prev = prev;
		}
	}

}
