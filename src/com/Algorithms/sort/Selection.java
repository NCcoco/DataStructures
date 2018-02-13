package com.Algorithms.sort;

/**
 * Selection
 * @description :选择排序
 * @time 2018年2月13日 下午5:30:08
 * @author NC
 */
public class Selection {

	/**
	 * @description : 选择排序算法大约需要N^2/2次比较 最大交换次数为N
	 * @param a
	 */
	public static <T extends Comparable<T>> void sort(T[] a) {
		Long start = System.currentTimeMillis();
		for(int i = 0; i < a.length; i ++) {
			for(int j = i + 1; j < a.length; j ++) {
				if(SortExample.less(a[j], a[i])) {
					SortExample.exch(a, i, j);
				}
			}
		}
		Long over = System.currentTimeMillis();
		System.out.println("选择排序花费了：" + (over - start) + "毫秒");
	}
	public static void main(String[] args) {
		Integer[] intArray1 = new Integer[10000];
		Integer[] intArray2 = new Integer[10000];
		for(int i = 0; i < intArray1.length; i ++) {
			Double d = Double.valueOf(Math.random() * 10000000);
			Integer integer = d.intValue();
			intArray1[i] = integer;
			intArray2[i] = integer;
		}
//		Insertion.sort(intArray1);
//		Selection.sort(intArray2);
		Selection s = new Selection();
//		SortExample.show(intArray);
	}
}
