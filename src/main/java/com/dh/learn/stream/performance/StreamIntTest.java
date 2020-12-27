package com.dh.learn.stream.performance;

import java.util.Arrays;
import java.util.Random;

/**
 * stream性能测试int类型
 * 500000000个int随机数求最小值
 * for循环方式最小值结果为:-2147483648-------耗时为:224
 * 串行stream方式最小值结果为:-2147483648-------耗时为:403
 * 并行stream方式最小值结果为:-2147483648-------耗时为:215
 * @author dongh
 * @since 2020年12月24日
 */
public class StreamIntTest {
	
	public static int[] arr = new int[500000000];
	
	public static void main(String[] args) {
		initArr();
		testFor(arr);
		testStream(arr);
		testParallelStream(arr);
	}
	
	public static void testFor(int[] arr) {
		int min = Integer.MAX_VALUE;
		long begin = System.currentTimeMillis();
		for(int i : arr) {
			if(i< min) {
				min = i;
			}
		}
		long end = System.currentTimeMillis();
		long dur = end-begin;
		System.out.println("for循环方式最小值结果为:"+ min+"-------"+"耗时为:"+dur);
	}
	
	public static void testStream(int[] arr) {
		long begin = System.currentTimeMillis();
		int min = Arrays.stream(arr).min().getAsInt();
		long end = System.currentTimeMillis();
		long dur = end-begin;
		System.out.println("串行stream方式最小值结果为:"+ min+"-------"+"耗时为:"+dur);
	}
	
	public static void testParallelStream(int[] arr) {
		long begin = System.currentTimeMillis();
		int min = Arrays.stream(arr).parallel().min().getAsInt();
		long end = System.currentTimeMillis();
		long dur = end-begin;
		System.out.println("并行stream方式最小值结果为:"+ min+"-------"+"耗时为:"+dur);
	}
	
	public static void initArr() {
		Random r = new Random();
		for (int i = 0; i < arr.length; i++) {
			arr[i] = r.nextInt();
		}
	}

}
