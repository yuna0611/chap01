package com.yuna.ex05;

import java.util.ArrayList;
import java.util.Collections;

public class Exercuse11_5 {
	public static void main(String[] args) {
		ArrayList<Student> list = new ArrayList();
		
		list.add(new Student("���ڹ�", 2, 1, 70, 90, 70));
		list.add(new Student("���ڹ�", 2, 2, 60, 100, 80));
		list.add(new Student("ȫ�浿", 1, 3, 100, 100, 100));
		list.add(new Student("���ü�", 1, 1, 90, 70, 80));
		list.add(new Student("���ڹ�", 1, 2, 80, 80, 90));
		
	//	Collections.sort(list, new Descending());
		Collections.sort(list, new BanNoAscending());
			
		for(Student a:list)
			System.out.println(a);
	}
}

