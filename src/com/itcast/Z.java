package com.itcast;

class X {
	Y b = new Y();
	X() {
		System.out.print("X");   //先于Y b = new Y()执行
	}
}
class Y {
	Y() {
		System.out.print("Y");
	}
}
public class Z extends X {
	Y y = new Y();//类加载时初始化   ->Y
	Z() {
		System.out.print("Z");    //调用父类无参的构造方法 ->new X()
	}
	public static void main(String[] args) {
		new Z();
	}
}