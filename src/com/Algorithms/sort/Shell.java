package com.Algorithms.sort;

/**
 * Shell
 * @description :希尔排序
 * @time 2018年2月15日 上午12:28:00
 * @author NC
 */
public class Shell {
	public static <T extends Comparable<T>> void sort(T[] a) {
		Long start = System.currentTimeMillis();
		int N = a.length;
		int h = 1;
		while(h < N/3) {
			h = 3 * h + 1;
		}
		while(h >= 1) {
			for(int i = h; i < N; i ++) {
				for(int j = i; j >= h; j -= h) {
					if(SortExample.less(a[j], a[j-h])) {
						SortExample.exch(a, j, j-h);
					} else {
						break;
					}
				}
			}
			h = h / 3;
		}
		Long over = System.currentTimeMillis();
		System.out.println("希尔排序花费了：" + (over - start) + "毫秒");
	}
}
