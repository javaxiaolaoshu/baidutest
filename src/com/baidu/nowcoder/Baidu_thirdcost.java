package com.baidu.nowcoder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Baidu_thirdcost {
/*
 * 度度熊想去商场买一顶帽子，商场里有N顶帽子，有些帽子的价格可能相同。
 * 度度熊想买一顶价格第三便宜的帽子，问第三便宜的帽子价格是多少？
 * 输入描述:
 * 首先输入一个正整数N（N <= 50），接下来输入N个数表示每顶帽子的价格（价格均是正整数，且小于等于1000）
 * 
 * 
 * 输出描述:
 * 如果存在第三便宜的帽子，请输出这个价格是多少，否则输出-1
 * 输入例子:
 *  10
 *  10 10 10 10 20 20 30 30 40 40
 *  输出例子1:
 *  30
 */
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int col = in.nextInt();
			int[] array = new int[col];
			for (int i = 0; i < col; i++) {
				array[i]=in.nextInt();
				if(!list.contains(array[i])) {
					list.add(array[i]);
				}
			}
			Collections.sort(list);
			if(list==null||list.size()<3) {
				System.out.println("-1");
			}else
				System.out.println(list.get(2));
		}
	}
}
