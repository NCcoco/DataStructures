package com.Algorithms.sort;

import java.util.HashSet;
import java.util.Set;

/**
 * SortExample
 * @description :
 * @time 2018年2月11日 下午10:16:19
 * @author NC
 */
public class SortExample {
	
	public static <T extends Comparable<T>> void sort(T[] a) {
		
	}
	
	
	/**
	 * @description : v小于w 返回 true v大于w返回false
	 * @param v
	 * @param w
	 * @return
	 */
	public static <T extends Comparable<T>> boolean less(T v, T w) {
		return v.compareTo(w) < 0;
	}
	
	/**
	 * @description : 
	 * @param a
	 * @param i
	 * @param j
	 */
	public static <T extends Comparable<T>> void exch(T[] a,int i, int j) {
		T temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public static <T extends Comparable<T>> void show(Comparable<T>[] a) {
		for(int i = 0; i < a.length; i ++) {
			System.out.print(a[i] + "\t");
			if((i + 1) % 20 == 0) {
				System.out.println();
			}
			
		}
	}
	
	public static void main(String[] args) {
		Set<Integer> intSet = new HashSet<>(100);
		for(int i = 0; i < intSet.size(); i ++) {
			intSet.add( (Integer) ((int) (Math.random() * 100 )));
		}
		// 就少一个排序算法了
	}
}
