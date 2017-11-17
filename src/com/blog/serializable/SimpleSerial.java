package com.blog.serializable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SimpleSerial {
//序列化测试
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		//对象持久化->文件
		File file = new File("C:\\test\\objectFile.txt");
		ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream(file));
		//Person1 person = new Person1("John", 23, Genders.MALE);//实现了Externalizable
		Person person = new Person("John", 23, Genders.MALE);
		oout.writeObject(person);// 将一个Person对象保存到文件
		//oout.writeObject(person);
		//oout.writeObject(Person3.getInstance()); // 保存单例对象
		oout.close();

		//对象还原->输出
		ObjectInputStream oin = new ObjectInputStream(new FileInputStream(file));
		Object newPerson = oin.readObject(); // 没有强制转换到Person类型
												// 从文件中读出被存储的Person对象
		oin.close();
		System.out.println(newPerson);
		//System.out.println(Person3.getInstance() == newPerson); // 将获取的对象与Person类中的单例对象进行相等性比较
	}
}
