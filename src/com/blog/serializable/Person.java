package com.blog.serializable;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

//实现Serializable序列化接口
public class Person implements Serializable {
	private String name;
	transient private Integer age;
	private Genders gender;

	public Person() {
		System.out.println("none-arg constructor");
	}

	public Person(String name, Integer age, Genders gender) {
		System.out.println("arg constructor");
		this.name = name;
		this.age = age;
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Genders getGender() {
		return gender;
	}

	public void setGender(Genders gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", gender=" + gender + "]";
	}

	// transient 修饰的属性，序列化还原
	private void writeObject(ObjectOutputStream out) throws IOException {
		// TODO Auto-generated method stub
		out.defaultWriteObject();
		out.writeInt(age);
	}
	// transient 修饰的属性，序列化还原
	private void readObject(ObjectInputStream in) throws ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		in.defaultReadObject();
		age = in.readInt();
	}
}
