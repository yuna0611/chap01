package com.yuna.ex06;

import java.util.HashSet;
import java.util.Set;

public class HashSetExample2 {
	public static void main(String[] args) {
		Set<Member> set = new HashSet<Member>();
		
		set.add(new Member("노유나", 27));
		set.add(new Member("노유나", 27));
		
		System.out.println("총 객체수 : "+set.size());
	}
}
