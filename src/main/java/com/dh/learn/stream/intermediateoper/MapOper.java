package com.dh.learn.stream.intermediateoper;

import java.util.Arrays;
import java.util.List;

/**
 * stream的map和flatMap操作
 * @author dongh
 * @since 2020年12月27日
 */
public class MapOper {
	
	public static void main(String[] args) {
		List<Integer> words1 = Arrays.asList(1,2,3,4);
		words1.stream().map(x -> x+1).forEach(System.out::println);
		
		List<String> words = Arrays.asList("hello", "world");
		words.stream()
		.map(w -> Arrays.stream(w.split("")))    //[[h,e,l,l,o],[w,o,r,l,d]]
		.forEach(System.out::println);
//		map输出的结果为两个对象：
//		java.util.stream.ReferencePipeline$Head@65ab7765
//		java.util.stream.ReferencePipeline$Head@1b28cdfa
		
		words.stream()
		.flatMap(w -> Arrays.stream(w.split("")))    //[[h,e,l,l,o],[w,o,r,l,d]]
		.forEach(System.out::println);
//		flatmap输出的结果：
//		h
//		e
//		l
//		l
//		o
//		w
//		o
//		r
//		l
//		d
	}
}
