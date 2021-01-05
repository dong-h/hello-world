package com.dh.learn.lambda;

/**
 * 内部类编译会生成class文件
 * @author dongh
 * @since 2020年12月28日
 */
public class InnerType {
	
	public static void main(String[] args) {
		InnerType i = new InnerType();
		i.test();
	}
	
	public void test() {
		Runnable run1 = new Runnable() {
			@Override
			public void run() {
				System.out.println(this);
			}
		};
		Runnable run2 = new Runnable() {
			@Override
			public void run() {
				System.out.println(toString());
			}
		};
		run1.run();
		run2.run();
	}
	
	@Override
	public String toString() {
		return "main";
	}
}
