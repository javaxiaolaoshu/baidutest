package com.baidu.nowcoder;

import java.util.Scanner;

/*
 *一个数轴上共有N个点，第一个点的坐标是度度熊现在位置，第N-1个点是度度熊的家。
 *现在他需要依次的从0号坐标走到N-1号坐标。
 *但是除了0号坐标和N-1号坐标，他可以在其余的N-2个坐标中选出一个点，并直接将这个点忽略掉，
 *问度度熊回家至少走多少距离？
 *输入描述:
 *输入一个正整数N, N <= 50。
 *
 *接下来N个整数表示坐标，正数表示X轴的正方向，负数表示X轴的负方向。绝对值小于等于100
 *输出描述:
 *输出一个整数表示度度熊最少需要走的距离。
 *
 *输入例子1:
 *4
 *1 4 -1 3
 *
 *输出例子1:
 *4
 */
public class Distance {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int distance = Distance.getDistance(in.nextInt());
		System.out.println(distance);
	}

	public static int getDistance(int N) {
		int sumDis_no = 0;
		int del = 0;
		int array[] = new int[N];
		Scanner in = new Scanner(System.in);
		for (int i = 0; i < N; i++) {
			array[i] = in.nextInt();
		}
		for (int j = 0; j < N; j++) {
			sumDis_no += Math.abs(array[j] - array[Math.max(0, j - 1)]);
		}
		for (int k = 1; k < N - 1; k++) {
			int a = Math.abs(array[k] - array[k - 1]) + Math.abs(array[k] - array[k + 1])
					- Math.abs(array[k + 1] - array[k - 1]);
			del = Math.max(a, del);
		}
		return sumDis_no - del;
	}
}
