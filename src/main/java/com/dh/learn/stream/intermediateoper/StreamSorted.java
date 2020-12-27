package com.dh.learn.stream.intermediateoper;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.dh.learn.entity.Person;

/**
 * stream排序规律(两个排序条件)
 * 都是正序 ，不加reversed
 * 都是倒序，最后面加一个reserved(负负得正???)
 * 先是倒序（加reserved），然后正序
 * 先是正序（加reserved），然后倒序（加reserved）
 * @author dongh
 * @since 2020.12.27
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
		list.stream().sorted(Comparator.comparing(Person::getGender).reversed()
			.thenComparing(Person::getAge).reversed())
			.forEach(System.out::println);
		System.out.println();
		
		/*//性别倒序，年龄倒序
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
			.forEach(System.out::println);*/
	}
}