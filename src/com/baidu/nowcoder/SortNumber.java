package com.baidu.nowcoder;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
 *度度熊有一个N个数的数组，他想将数组从大到小排好序，但是萌萌的度度熊只会下面这个操作：
 *任取数组中的一个数然后将它放置在数组的最后一个位置。
 *问最少操作多少次可以使得数组从小到大有序？ 
 *输入描述:
 *首先输入一个正整数N，接下来的一行输入N个整数。(N <= 50, 每个数的绝对值小于等于1000)
 *输出描述:
 *输出一个整数表示最少的操作次数。
 *输入例子1:
 *4
 *19 7 8 25
 *输出例子1:
 *2
 */
public class SortNumber {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNextLine()) {
			int num = in.nextInt();
			int arr[] = new int[num];
			int i; //
			Map<Integer, Integer> map = new HashMap<>();
			for (i = 0; i < num; i++) {
				arr[i] = in.nextInt();
				map.put(arr[i], i); // 将数组的值作为key，值得位置作为value存储在hashmap中
			}
			int count = 0;
			Arrays.sort(arr);
			// System.out.println(Arrays.toString(arr));
			/*
			 * for(Map.Entry<Integer, Integer> m:map.entrySet()) {
			 * System.out.println(m.getKey()+"---"+m.getValue()); }
			 */
			for (int j = 0; i < num - 1; j++) {
				if (map.get(arr[j]) > map.get(arr[j + 1])) {
					map.put(arr[j + 1], i++);
					count++;
					System.out.println(count);
				}
			}
			/*
			 * System.out.println("***********"); for(Map.Entry<Integer, Integer>
			 * m:map.entrySet()) { System.out.println(m.getKey()+"---"+m.getValue()); }
			 */
			System.out.println(count);
		}
	}

	// 方法二：
	/*
	 * 思路:排序后数组与原数组按索引进行比较 arr[i]=sortArr[j]; 输入为 19 7 8 25 ，用 arr1表示 排序后 7 8 19 25
	 * ，用 arr2 表示 都从数组第一个元素开始 ： 7 和 19 比较 ，7 < 19 , 继续看arr1 的下一个元素 跟 arr2 的第一个元素 7
	 * 比较，此时 7 = 7 所以count++ ， 看两个数组后面的元素 ， 都是 8 ，此时 count++ ，继续看 25 > 19 ，到此结束。
	 * 所以count = 2 一共有 n 个元素，所以需要移动 n - count 次
	 */
	public static class Main {
		public static void method2() {
			Scanner scan = new Scanner(System.in);
			int n = scan.nextInt();
			int[] arr = new int[n];
			int[] sortArr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = scan.nextInt();
				sortArr[i] = arr[i];
			}
			Arrays.sort(sortArr);
			int count = 0;
			int j = 0;
			for (int i = 0; i < n; i++) {
				if (arr[i] == sortArr[j]) {
					count++;
					j++;
				}
			}
			System.out.println(n - count);
		}
	}
}
