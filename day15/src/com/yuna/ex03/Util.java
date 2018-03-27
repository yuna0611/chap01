package com.yuna.ex03;

import com.yuna.ex01.Box;

public class Util {
	public static <T> Box <T> boxing(T t){
		Box<T> box = new Box<T>();
		box.setT(t);
		return box;
	}
}
