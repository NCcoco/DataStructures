package com.Algorithms.sort;

/**
 * Merge
 * @description :使用了额外存储空间得归并排序
 * @time 2018年2月16日 下午5:31:23
 * @author NC
 */
public class Merge {
	private static Comparable[] aux;
	
	public static <T extends Comparable<T>> void merge(Comparable<T>[] a, int low, int middle, int high){
		//将a数组视为2个数组
		int i = low; // 前半边
		int j = middle + 1; // 后半边
		for(int k = low; k <= high; k ++) {
			aux[k] = a[k];//数据迁移到新数组中 
		}
		for(int k = low; k <= high; k ++) {
		    if(i > middle){// 如果i已经大于middle了，说明数组前半部分已经用完了，直接使用后半部分就好了
		    	a[k] = aux[j];
		    	j++;
		    } else if(j > high) { // 如果j已经大于high了，说明数组后半部分已经用完了，直接用前半部分好了
		    	a[k] = aux[i];
		    	i++;
		    	// 如果上面两个条件均不满足，就会进入下面得步骤
		    } else if(SortUtils.less((T)aux[i], (T)aux[j])) {
				a[k] = aux[i];
				i++;
			} else {
				a[k] = aux[j];
				j++;
			}
		}
	}
	
	public static void sort(Comparable[] a) {
		Long start = System.currentTimeMillis();
		aux = new Comparable[a.length];
		sort(a, 0, a.length - 1);
		Long over = System.currentTimeMillis();
		System.out.println("归并自上而下型排序花费了：" + (over - start) + "毫秒");
	}
	
	/**
	 * @description : 嵌套了插入排序的归并排序，有一丁点的性能提升
	 * @param a
	 * @param low
	 * @param high
	 */
	private static <T extends Comparable<T>> void sort(T[] a, int low, int high) {
		// 如果低已经大于或等于顶（通常只可能等于顶），则说明只有一个元素了，就直接返回
		if (low >= high) {
			return;
		} else if (high - low <= 14) {
			// 根据最坏的情况 插入排序是N^2/2 归并排序是6*N*lg(N) 两个方程在14处相交，再增大则归并快，减小则插入快
			for (int i = low + 1; i <= high; i++) {
				for (int j = i; j > low; j--) {
					if (SortUtils.less((T) a[j], (T) a[j - 1])) {
						SortUtils.exch(a, j, j - 1);
					} else {
						break;
					}
				}
			}
			return;
		}
		int middle = low + (high - low) / 2;
		sort(a, low, middle);
		sort(a, middle + 1, high);
		merge(a, low, middle, high);

	}
}
