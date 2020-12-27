package com.dh.learn.stream.intermediateoper;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

import com.dh.learn.entity.Person;

/**
 * Stream的filter操作
 * @author dongh
 * @since 2020年12月27日
 */
public class FilterOper {
	
	private static Predicate<Person> ageThan30 = x -> x.getAge() >30;
	
	private static Predicate<Person> genderM = x -> x.getGender().equals("M");
	
	private static Predicate<Integer> than20 = x -> x > 20;
	private static Predicate<Integer> oshu = x -> x % 2 ==0;
	
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
		
		list.stream().filter(ageThan30.and(genderM)).forEach(System.out::println);
		
		Integer[] arr = {1,5,13,45,25,46,22,40,88};
//		Stream.of(arr).filter(x -> x > 20 && x % 2 == 0).forEach(System.out::println);
		Stream.of(arr).filter(than20.and(oshu)).forEach(System.out::println);
	}
	
}
