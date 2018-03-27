package com.yuna.ex02;

import java.util.Comparator;


public class Descending implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		// TODO Auto-generated method stub
		return o2.name.compareTo(o1.name);
	}
}
