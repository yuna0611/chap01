package com.yuna.ex02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.TreeSet;

public class TressSetExample2 {
	public static void main(String[] args) {
		TreeSet<Integer> scores = new TreeSet<Integer>();
		scores.add(new Integer(87));
		scores.add(new Integer(98));
		scores.add(new Integer(75));
		scores.add(new Integer(95));
		scores.add(new Integer(80));

	/*	NavigableSet<Integer> descendingSet = scores.descendingSet();
		for(Integer a : descendingSet)
			System.out.print(a + " ");
		System.out.println();
		
		NavigableSet<Integer> ascendingSet = descendingSet.descendingSet();
		for(Integer a : ascendingSet)
			System.out.print(a + " ");*/
		
		ArrayList list = new ArrayList(scores);
		Collections.sort(list);
		
		Iterator<Integer> iterator = scores.iterator();
		while(iterator.hasNext()) {
			Integer element = iterator.next();
			System.out.print(element+" ");
		}
	}
}







