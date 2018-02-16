package com.Algorithms.sort;

/**
 * Insertion
 * @description :插入排序
 * @time 2018年2月13日 下午8:56:48
 * @author NC
 */
public class Insertion {
	/**
	 * @description : 插入排序算法
	 * @param a
	 */
	public static <T extends Comparable<T>> void sort(T[] a) {
		Long start = System.currentTimeMillis();
		for(int i = 1; i < a.length; i ++) {
			for(int j = i; j > 0; j --) {
				if(SortUtils.less(a[j], a[j-1])) {
					SortUtils.exch(a, j, j-1);
				} else {
					break;
				}
			}
		}
		Long over = System.currentTimeMillis();
		System.out.println("插入排序花费了：" + (over - start) + "毫秒");
	}
}
