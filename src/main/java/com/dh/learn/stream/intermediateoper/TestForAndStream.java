package com.dh.learn.stream.intermediateoper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * for循环和stream方式的区别
 * @author dongh
 * @since 2020年12月27日
 */
public class TestForAndStream {
	
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("bcd");
		list.add("cde");
		list.add("def");
		list.add("abc");
		List<String> result = list.stream().parallel()
				.filter(e -> e.length() >= 3)
				.map(e -> e.charAt(0))
				.peek(e -> System.out.println( Thread.currentThread().getName()+":"+e))
				.sorted()
				.peek(e -> System.out.println("++++" + e))
				.map(e -> String.valueOf(e))
				.collect(Collectors.toList());
		System.out.println("----------------------------");
		System.out.println(result);
//		targetMethod();
	}
	
	public static void targetMethod() { 
		List<String> list = new ArrayList<>();
		list.add("bcd");
		list.add("cde");
		list.add("def");
		list.add("abc");
		List<String> result =  new ArrayList<>(list.size());
		for (String str : list) {
			if (str.length() >= 3) {
				char e = str.charAt(0);
				String tempStr = String.valueOf(e);
				result.add(tempStr);
				}
			} 
		System.out.println("----------------------------");
		System.out.println(result); 
	}
}
