package com.dh.learn.lambda;

/**
 * 
 * @author dongh
 * @since 2020年12月28日
 */
public class TextLambda {
	
	final static String hello = "Hello, ";
	private static String goodbye = "Goodbye, ";
	public static void main(String[] args) {
		String num = "aa";
		GreetingMessage message1 = (String message) -> System.out.println(hello + message);
		GreetingMessage message2 = (message) ->
		{
			goodbye = "the time is late, I'd go now, goodbye";
//			goodbye += "the time is late, I'd go now, ";
			System.out.println(goodbye + message+ num);
			System.out.println();
		};
		message1.sayMessage("张三");
		message2.sayMessage("李四");
		System.out.println(goodbye);
	}
	
}

@FunctionalInterface
interface GreetingMessage {
	void sayMessage(String message);
}
