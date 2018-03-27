package com.yuna.ex02;

import java.util.NavigableSet;
import java.util.TreeSet;

public class treeSetExample3 {
	public static void main(String[] args) {
		TreeSet<String> treeSet = new TreeSet<String>();
		treeSet.add("apple");
		treeSet.add("forever");
		treeSet.add("description");
		treeSet.add("ever");
		treeSet.add("zoo");
		treeSet.add("base");
		treeSet.add("guess");
		treeSet.add("cherry");
		
		System.out.println("[c~f 사이의 단어 검색]");
		NavigableSet<String> rangeSet = treeSet.subSet("c",true,"fo",true);
		for(String a : rangeSet)
			System.out.println(a);
		System.out.println("===================================");
		rangeSet = treeSet.headSet("c",true);
		for(String a : rangeSet)
			System.out.println(a);
		System.out.println("===================================");
		rangeSet = treeSet.tailSet("f",true);
		for(String a : rangeSet)
			System.out.println(a);
	}
}
