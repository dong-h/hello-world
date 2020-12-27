package com.dh.learn.stream.intermediateoper;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * stream的reduce操作
 * @author dongh
 * @since 2020年12月27日
 */
public class ReduceOper {
	
	public static void main(String[] args) {
		//一个参数，累加器
		Optional<Integer> optional = Stream.of(1,2,3,4).reduce(Integer::sum);
		System.out.println(optional.get());
		
		//两个参数，初始值和累加器
		Integer result1 = Stream.of(1,2,3,4).reduce(0,Integer::sum);
		System.out.println(result1);
		
		//三个参数，初始值、合并器、累加器
		Integer result2 = Stream.of(1,2,3,4).parallel().reduce(0,Integer::sum,Integer::sum);
		System.out.println(result2);
	}
}
