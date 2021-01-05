package com.dh.learn.lambda;

import java.awt.event.ActionListener;
import java.util.concurrent.Callable;

import javax.swing.JButton;

/**
 * lambda表达式方式编辑之后不会生成多的class文件
 * @author dongh
 * @since 2020年12月28日
 */
@SuppressWarnings("all")
public class LambdaType {
	
	public static void main(String[] args) {
		/*ActionListener action = x -> System.out.println(x.getID());
		Callable<String> c = () -> "done";*/
		
		LambdaType l = new LambdaType();
		l.test();
	}
	
	public void test() {
		Runnable run1 = () -> System.out.println(this);
		Runnable run2 = () -> System.out.println(toString());
		run1.run();
		run2.run();
	}
	
	@Override
	public String toString() {
		return "lambdaType";
	}

}
