package com.blog.serializable;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
//实现Serializable序列化接口
public class Person1 implements Externalizable {
	private  String name;
	transient private Integer age;
	private Genders gender;
	public Person1() {
		System.out.println("none-arg constructor");
	}
	public Person1(String name, Integer age, Genders gender) {
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
	//transient 修饰的属性，序列化还原
	private void writeObject(ObjectOutputStream out) throws IOException {
		// TODO Auto-generated method stub
		//调用ObjectOutputStream中的defaultWriteObject()方法
		out.defaultWriteObject();
		out.writeInt(age);
	}
	//transient 修饰的属性，序列化还原
	private void readObject(ObjectInputStream in) throws ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		//
		in.defaultReadObject();
		age=in.readInt();
	}
	
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		// TODO Auto-generated method stub
		out.writeObject(name);
		out.writeInt(age);
		out.writeObject(gender);
	}
	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		name=(String) in.readObject();
		age=in.readInt();
		gender=(Genders) in.readObject();
	}
}