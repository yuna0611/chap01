package com.yuna.ex02;

import java.util.Iterator;
import java.util.TreeSet;

public class TressSetExample {
	public static void main(String[] args) {
		TreeSet<Integer> scores = new TreeSet<Integer>();
		scores.add(new Integer(87));
		scores.add(new Integer(98));
		scores.add(new Integer(75));
		scores.add(new Integer(95));
		scores.add(new Integer(80));

		Iterator<Integer> iterator = scores.iterator();
		while(iterator.hasNext()) {
			Integer element = iterator.next();
			System.out.print(element+" ");
			
		}
	}
}







