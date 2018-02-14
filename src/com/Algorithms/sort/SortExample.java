package com.Algorithms.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * SortExample
 * @description :
 * @time 2018年2月11日 下午10:16:19
 * @author NC
 */
public class SortExample {
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
		List<Integer[]> list = new ArrayList<>();
		int num = 3;
		
		for(int i = 0; i < num; i ++) {
			list.add(new Integer[10000]);
		}
		for(int i = 0; i < list.get(0).length; i ++) {
			Double d = Double.valueOf(Math.random() * 10000000);
			Integer integer = d.intValue();
			for(int j = 0; j < num; j ++) {
				list.get(j)[i] = integer;
			}
		}
		int index = 0;
		Insertion.sort(list.get(index++));
		Selection.sort(list.get(index++));
		Shell.sort(list.get(index++));
	}
}
