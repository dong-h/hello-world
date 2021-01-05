package com.dh.learn.stream;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author dongh
 * @since 2020年12月27日
 */
public class StreamOper {
	
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("Apple");
		list.add("bug");
		list.add("ABC");
		list.add("Dog");
		list.stream().filter(x -> x.startsWith("A"))
		.mapToInt(x -> x.length())
		.max();
		
		int longest = 0;
		for(String str : list){
			if(str.startsWith("A")){				// 1. filter(), 保留以A开头的字符串
				int len = str.length();				// 2. mapToInt(), 转换成长度
				longest = Math.max(len, longest);	// 3. max(), 保留最长的长度
			}
		}
	}
}
