package com.yuna.ex01;

public class BoxExample {
	public static void main(String[] args) {
		Box<String> box1 = new Box<String>();
		box1.setT("Hello");
		String str = box1.getT();
		
		Box<Integer> box2 = new Box<Integer>();
		box2.setT(6);
		int value = box2.getT();
		
		System.out.println("str == "+str+", value == "+value);
	}
}
