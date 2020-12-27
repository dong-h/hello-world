package com.dh.learn.stream.performance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * stream性能测试object类型
 * for循环方式耗时为:118
 * 串行stream方式耗时为:125
 * 并行stream方式耗时为:84
 * @author dongh
 * @since 2020年12月24日
 */
public class StreamIntTest3 {
	
	public static List<Order> orders;
	
	public static void main(String[] args) {
		orders = Order.genOrders(1000000);
		testFor();
		testStream();
		testParallelStream();
	}
	
	public static void testFor() {
		long begin = System.currentTimeMillis();
		Map<String, Double> map = new HashMap<>();
		for(Order od : orders){
			String userName = od.getUserName();
			Double v; 
			if((v=map.get(userName)) != null){
				map.put(userName, v+od.getPrice());
			}else{
				map.put(userName, od.getPrice());
			}
		}
		long end = System.currentTimeMillis();
		long dur = end-begin;
//		map.forEach((s1,s2)->{System.out.println(s1+"员工的总价为:"+ s2);});
		System.out.println("for循环方式耗时为:"+dur);
	}
	
	public static void testStream() {
		long begin = System.currentTimeMillis();
		orders.stream().collect(
				Collectors.groupingBy(Order::getUserName, 
				Collectors.summingDouble(Order::getPrice)));
		long end = System.currentTimeMillis();
		long dur = end-begin;
//		map.forEach((s1,s2)->{System.out.println(s1+"员工的总价为:"+ s2);});
		System.out.println("串行stream方式耗时为:"+dur);
	}
	
	public static void testParallelStream() {
		long begin = System.currentTimeMillis();
		orders.parallelStream().collect(
				Collectors.groupingBy(Order::getUserName, 
				Collectors.summingDouble(Order::getPrice)));
		long end = System.currentTimeMillis();
		long dur = end-begin;
//		map.forEach((s1,s2)->{System.out.println(s1+"员工的总价为:"+ s2);});
		System.out.println("并行stream方式耗时为:"+dur);
	}
}

class Order{
	private String userName;
	private double price;
	private long timestamp;
	public Order(String userName, double price, long timestamp) {
		this.userName = userName;
		this.price = price;
		this.timestamp = timestamp;
	}
	public String getUserName() {
		return userName;
	}
	public double getPrice() {
		return price;
	}
	public long getTimestamp() {
		return timestamp;
	}

	public static List<Order> genOrders(int listLength){
		ArrayList<Order> list = new ArrayList<>(listLength);
		Random rand = new Random();
		int users = listLength/200;// 200 orders per user
		users = users==0 ? listLength : users;
		ArrayList<String> userNames = new ArrayList<>(users);
		for(int i=0; i<users; i++){
			userNames.add(UUID.randomUUID().toString());
		}
		for(int i=0; i<listLength; i++){
			double price = rand.nextInt(1000);
			String userName = userNames.get(rand.nextInt(users));
			list.add(new Order(userName, price, System.nanoTime()));
		}
		return list;
	}
	
	@Override
	public String toString(){
		return userName + "::" + price;
	}
}
