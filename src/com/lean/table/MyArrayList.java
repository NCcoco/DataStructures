package com.lean.table;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Administrator
 * 实现了迭代器接口，这样可以在增强for循环中使用本类
 * @param <T>
 */
public class MyArrayList<T> implements Iterable<T> { 
	
	/**
	 * 默认的数组容量
	 */
	private static final int DEFAULT_CAPACITY = 10;
	
	private Object[] items = new Object[DEFAULT_CAPACITY];
	
	private int size;
	
	public MyArrayList() {
		doClear();
	}
	
	/**
	 * 清除数组中的所有数据
	 */
	public void clear() {
		doClear();
	}
	
	private void doClear() {
		size = 0;
		ensureCapacity(DEFAULT_CAPACITY);
	}
	
	public int size() {
		return size;
	}
	public boolean isEmpty() {
		return size() == 0;
	}
	public void trimToSize() {
		ensureCapacity(size);
	}
	/**
	 * 扩容
	 * @param newCapacity
	 */
	public void ensureCapacity(int newCapacity) {
		if(newCapacity < size()) {
			return;
		}
		items = Arrays.copyOf(items, newCapacity);
	}
	
	/**
	 * 获取指定下标的元素值
	 * @param idx
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public T get(int idx) {
		if(idx >= size() || idx < 0) {
			throw new ArrayIndexOutOfBoundsException();
		}
		return (T) items[idx];
	}
	
	/**
	 * 更换指定下标的元素值
	 * @param idx
	 * @param newVal
	 */
	public void set(int idx, T newVal) {
		if(idx >= size() || idx < 0) {
			throw new ArrayIndexOutOfBoundsException();
		}
		items[idx] = newVal;
	}
	
	public boolean add(T t) {
		add( size(), t);
		return true;
	}
	
	public void add(int idx, T t) {
		if(items.length == size()) {
			// 扩容一半
			ensureCapacity(size() + size()/2 + 1);
		}
		for(int i = size(); i > idx ; i --) {
			items[i] = items[i - 1];
		}
		items[idx] = t;
		size ++;
	}
	
	/**
	 * 一个最简单的查询算法
	 * @param t
	 * @return
	 */
	public int indexOf(T t) {
		for(int i = 0; i < size(); i ++) {
			if(items[i].equals(t)) {
				return i;
			}
		}
		return -1;
	}
	
	public boolean remove(T t) {
		if(indexOf(t) < 0) {
			return false;
		}
		return remove(indexOf(t));
	}
	
	public boolean remove(int idx) {
		if(idx < 0 || idx >= size()) {
			throw new ArrayIndexOutOfBoundsException();
		}
		size --;
		for(int i = idx; i < size(); i ++) {
			items[i] = items[i + 1];
		}
		return true;
	}
	
	public boolean contains(T t) {
		for(int i = 0; i < size(); i ++) {
			if(items[i].equals(t)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 
	 * 使用了匿名内部類的返回
	 */
	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			private int current = 0;

			@Override
			public boolean hasNext() {
				return current < size();
			}

			@SuppressWarnings("unchecked")
			@Override
			public T next() {
				if (!hasNext()) {
					throw new NoSuchElementException();
				}
				return (T) items[current++];
			}

			public void remove() {
				MyArrayList.this.remove(current--);
				MyArrayList.this.size--;
			}

		};
	}
}
