package com.baidu.nowcoder;

import java.util.ArrayList;
import java.util.List;

public class LoopQueue {

	public static void main(String[] args) {
		loopqueue(8, 4);
	}

	public static void loopqueue(int n, int m) {
		int i, j, t;
		// n-数组长度，m-以报号为m出列
		List<Integer> list = new ArrayList<>();
		int arr[] = new int[n];
		for (i = 0; i < n; i++) {
			arr[i] = i + 1;
			list.add(arr[i]);
			//System.out.println(list.get(i));
		}
		t = 0;
		for (i = n; i >= 1; i--) {
			t = (t + m - 1) % i; // 得到出列数的数组下标
			System.out.print(list.get(t));
			list.remove(list.get(t)); // 去除已经出循环的数
			for (j = t + 1; j < i - 1; j++) {
				arr[j - 1] = arr[j];
				// list.remove(arr[j]);
			}
		}
	}
}
