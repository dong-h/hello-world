package com.dh.learn.stream.performance;

import java.util.ArrayList;
import java.util.Random;

/**
 * stream性能测试string类型
 * 30000000个string求最小值
 * for循环方式最小值结果为:aaaaaixusb-------耗时为:246
 * 串行stream方式最小值结果为:aaaaaixusb-------耗时为:352
 * 并行stream方式最小值结果为:aaaaaixusb-------耗时为:167
 * @author dongh
 * @since 2020年12月24日
 */
public class StreamIntTest2 {
	
	public static ArrayList<String> list;
	
	public static void main(String[] args) {
		initArrayList(30000000);
		testFor();
		testStream();
		testParallelStream();
	}
	
	public static void testFor() {
		long begin = System.currentTimeMillis();
		String minStr = null;
		boolean first = true;
		for(String str : list){
			if(first){
				first = false;
				minStr = str;
			}
			if(minStr.compareTo(str)>0){
				minStr = str;
			}
		}
		long end = System.currentTimeMillis();
		long dur = end-begin;
		System.out.println("for循环方式最小值结果为:"+ minStr+"-------"+"耗时为:"+dur);
	}
	
	public static void testStream() {
		long begin = System.currentTimeMillis();
		String min = list.stream().min(String::compareTo).get();
		long end = System.currentTimeMillis();
		long dur = end-begin;
		System.out.println("串行stream方式最小值结果为:"+ min+"-------"+"耗时为:"+dur);
	}
	
	public static void testParallelStream() {
		long begin = System.currentTimeMillis();
		String min = list.stream().parallel().min(String::compareTo).get();
		long end = System.currentTimeMillis();
		long dur = end-begin;
		System.out.println("并行stream方式最小值结果为:"+ min+"-------"+"耗时为:"+dur);
	}
	
	public static void initArrayList(int length) {
		list = new ArrayList<>(length);
		Random rand = new Random();
		int strLength = 10;
		StringBuilder buf = new StringBuilder(strLength);
		for(int i=0; i<length; i++){
			buf.delete(0, buf.length());
			for(int j=0; j<strLength; j++){
				buf.append((char)('a'+ rand.nextInt(26)));
			}
			list.add(buf.toString());
		}
	}

}
