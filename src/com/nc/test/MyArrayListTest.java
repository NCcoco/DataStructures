package com.nc.test;

import java.util.Iterator;

import com.lean.table.MyArrayList;

public class MyArrayListTest {
	public static void main(String[] args) {
		MyArrayList<Integer> arrayList = new MyArrayList<>();
		for(int i = 0; i < 100; i++) {
			arrayList.add( (int) (Math.random() * 1000));
		}
		System.out.println("数组长度："+ arrayList.size());
		System.out.println("增强for循环[");
		for(Integer integer : arrayList) {
			System.out.print(integer + ", ");
		}
		System.out.println("]");
		System.out.println("普通for循环[");
		for(int i = 0; i < 100; i++) {
			System.out.print(arrayList.get(i) + ", ");
		}
		System.out.println("]");
		Iterator<Integer> iTerator = arrayList.iterator();
		while(iTerator.hasNext()) {
			iTerator.next();
			iTerator.remove();
		}
		System.out.println("数组长度："+ arrayList.size());
		
	}
}
