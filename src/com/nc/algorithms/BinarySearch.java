package com.nc.algorithms;

import java.util.Arrays;

public class BinarySearch {
	
	/**
	 * 线性查询
	 * @param key
	 * @param a
	 * @return
	 */
	public static int find(int key, int[] a) {
		for(int i = 0; i < a.length; i++) {
			if(key == a[i]) {
				return i;
			}
		}
		return -1;
	}
	/**
	 * 二分法查找元素的下标
	 * @param key
	 * @param a 数组必须是有序的
	 * @return
	 */
	public static int rank(int key, int[] a) {
		int lo = 0;
		int hi = a.length - 1;
		while(lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if(a[mid] > key) {
				hi = mid - 1;
			} else if(a[mid] < key){
				lo = mid + 1;
			} else {
				return mid;
			}
		}
		return -1;//说明没找到
	}
	
	public static void main(String[] args) {
		int[] whitelist = new int[10000000];
		for(int i = 0; i < 10000000; i++) {
			whitelist[i] = (int) (Math.random() * 1000);
//			System.out.println(whitelist[i]);
		}
		
//		whitelist[100000000] = 999;
		Arrays.sort(whitelist);
		long current = System.currentTimeMillis();
		System.out.println(rank(999,whitelist));
		System.out.println("搜寻花费了："+ (System.currentTimeMillis() - current) + "毫秒");
		long current1 = System.currentTimeMillis();
		System.out.println(find(999,whitelist));
		System.out.println("搜寻花费了："+ (System.currentTimeMillis() - current1) + "毫秒");
	}
}