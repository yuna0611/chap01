package com.yuna.ex03;

import com.yuna.ex01.Box;

public class BoxingExample {
	public static void main(String[] args) {
		Box<Integer> box1 = Util.<Integer>boxing(100);
		int intValue = box1.getT();
		
		Box<String> box2 = Util.boxing("ȫ�浿");
		String strValue = box2.getT();
		
		System.out.println(intValue+","+ strValue);
	}
}
