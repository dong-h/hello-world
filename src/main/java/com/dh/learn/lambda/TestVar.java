package com.dh.learn.lambda;

/**
 * lambda表达式对外部局部变量的引用
 * @author dongh
 * @since 2020年12月28日
 */
public class TestVar {
	
	public static void main(String[] args) {
		String str = "abc";
		HandleMessage handler = x -> System.out.println(x+str);
		//str = "cde";Local variable str defined in an enclosing scope must be final or effectively final
		handler.sayMessage("hello ");
		
//		int i=0;
		HandleMessage handler1 = x -> {
		//Lambda expression's local variable i cannot redeclare another local variable defined in an enclosing scope. 
			for(int i=0;i<10;i++) {
				System.out.println(x+i);
			}
			
			//函数式接口没有声明抛出异常，lambda表达式中的异常只能捕获处理，不能抛出
			//throw new Exception();
		};
		handler1.sayMessage("hello ");
	}
}

@FunctionalInterface
interface HandleMessage {
	void sayMessage(String message);
}