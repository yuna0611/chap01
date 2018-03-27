package com.yuna.ex05;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetExample {
	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		
		set.add("Java");
		set.add("JDBC");
		set.add("iBATIS");
		set.add("Servlet/JSP");
		set.add("Java");
		
		int size = set.size();
		System.out.println("ÃÑ °³¼ö  : "+size);

		Iterator<String> iterator = set.iterator();
		while(iterator.hasNext()) {
			String element = iterator.next();
			System.out.println("\t"+element);
			
		}
		
		set.remove("iBATIS");
		set.remove("JDBC");
		
		System.out.println("ÃÑ °´Ã¼¼ö : "+set.size());
		
		iterator=set.iterator();
		while(iterator.hasNext()) {
			String element = iterator.next();
			System.out.println("\t"+element);
		}
		
		set.clear();
		if(set.isEmpty())
			System.out.println("ºñ¾î ÀÖÀ½");
	}
}
