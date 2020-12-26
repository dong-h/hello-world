package com.dh.learn.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * stream排序规律(两个排序条件)
 * 都是正序 ，不加reversed
 * 都是倒序，最后面加一个reserved(负负得正???)
 * 先是倒序（加reserved），然后正序
 * 先是正序（加reserved），然后倒序（加reserved）
 * @author dongh
 * @since 2020.12.27 00:22:29
 */
public class StreamSorted {
	
	public static void main(String[] args) {
		List<Person> list = new ArrayList<>();
		list.add(new Person("001", "tom", "M", 23));
		list.add(new Person("002", "zhangsan", "M", 45));
		list.add(new Person("003", "lisi", "F", 27));
		list.add(new Person("004", "lion", "M", 31));
		list.add(new Person("005", "lucky", "F", 44));
		list.add(new Person("006", "summer", "F", 56));
		list.add(new Person("007", "kangkang", "M", 18));
		list.add(new Person("008", "king", "M", 55));
		list.add(new Person("009", "meta", "F", 24));
		list.add(new Person("010", "icon", "M", 47));
		list.add(new Person("011", "huahua", "F", 17));
		
		//性别倒序，年龄倒序
		System.out.println("性别倒序，年龄倒序");
		list.stream().sorted(Comparator.comparing(Person::getGender)
			.thenComparing(Person::getAge).reversed())
			.forEach(System.out::println);
		System.out.println();
		
		//性别正序，年龄倒序
		System.out.println("性别正序，年龄倒序");
		list.stream().sorted(Comparator.comparing(Person::getGender).reversed()
			.thenComparing(Person::getAge).reversed())
			.forEach(System.out::println);
		System.out.println();
		
		//性别倒序，年龄正序
		System.out.println("性别倒序，年龄正序");
		list.stream().sorted(Comparator.comparing(Person::getGender).reversed()
			.thenComparing(Person::getAge))
			.forEach(System.out::println);
		System.out.println();
		
		//性别正序，年龄正序
		System.out.println("性别正序，年龄正序");
		list.stream().sorted(Comparator.comparing(Person::getGender)
			.thenComparing(Person::getAge))
			.forEach(System.out::println);
	}
}

class Person{
	
	private String id;
	
	private String name;
	
	private String gender;
	
	private int age;
	
	/**
	 * @param id
	 * @param name
	 * @param gender
	 * @param age
	 */
	public Person(String id, String name, String gender, int age) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.age = age;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "{ " + "id:"+this.id+ ", name:"+this.name+ ", gender:"+this.gender+ ", age:"+this.age+" }";
	}
}