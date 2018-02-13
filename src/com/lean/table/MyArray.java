package com.lean.table;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

import com.nc.utils.NcValidator;

public class MyArray<E> implements Collection<E>, Comparable<E> {
	//
	private static final int DEFAULT_ARR_SIZE = 10;
	// 虚拟机对数组保留一些标题字所以需要减去8
	private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
	// 为什么不直接使用E[]而是Object[]
	// 是因为编译器会将整个类写为非泛型类,即Object传给JVM，如果在get()方法中没有加入强制类型转换，您将会收到一个警告
	// 而对于泛型方法，编译器会插入强制类型转换来保证它是有效的
	private Object[] arr = new Object[DEFAULT_ARR_SIZE];
	/**
	 * 记录数组中的元素数量
	 */
	private int size;

	public MyArray() {

	}

	public MyArray(Object[] arr) {
		this.arr = arr;
	}

	/**
	 * 插入元素
	 * 
	 * @param loc
	 *            位置
	 * @param n
	 *            要插入的元素
	 */
	@SuppressWarnings("unchecked")
	public void insert(Integer loc, E... n) {
		NcValidator.AllNotNull(loc, n);
		if (loc > size || loc < 0) {
			throw new RuntimeException("下标越界");
		}
		int minCapacity = n.length + size;
		if (minCapacity > arr.length) {
			grow(minCapacity);
		}
		// 挪位置用了O(n.length)步
		for (int i = (size - 1); i >= loc; i--) {
			arr[i + n.length] = arr[i];
		}
		// 插入需要O(n.length)次
		int j = 0; // 临时变量
		for (int i = loc; i < (loc + n.length); i++) {
			arr[i] = n[j++];
		}
		size = size + n.length;
	}

	/**
	 * 数组扩容
	 * 
	 * @param minCapacity
	 */
	private void grow(int minCapacity) {
		int oldCapacity = arr.length;
		int newCapacity = oldCapacity + (oldCapacity >> 1);
		if (newCapacity - minCapacity < 0) {
			newCapacity = minCapacity;
		}
		if ((newCapacity - MAX_ARRAY_SIZE) > 0) {
			throw new RuntimeException("下标越界");
		}
		arr = Arrays.copyOf(arr, newCapacity);
	}

	@SuppressWarnings("unchecked")
	public E get(int index) {
		rangeCheck(index);
		return (E) arr[index];
	}

	public int getLength() {
		return this.arr.length;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("MyArray [");
		for (int i = 0; i < size; i++) {
			sb.append(arr[i].toString() + ",");
		}
		sb.deleteCharAt(sb.length() - 1);
		sb.append("]");
		return sb.toString();
	}

	/**
	 * 数组下标检查
	 * 
	 * @param index
	 */
	private void rangeCheck(int index) {
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException();
	}

	@Override
	public boolean add(E e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
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
	public Iterator<E> iterator() {
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

	/**
	 * 获取数组大小
	 * 
	 * @return
	 */
	@Override
	public int size() {
		return this.size;
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

	@Override
	public int compareTo(E o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
