package com.yuna.ex04;

import java.util.Comparator;

public class DescendingComparator implements Comparator<Fruit>{
	
	@Override 
	public int compare(Fruit o1, Fruit o2) {
		int a = o2.name.compareTo(o1.name);
		return a;
	/*	if(o1.name.compareTo(o2.name))
			return 1;
		else if(o1.name.equals(o2.name))
			return 0;
		else
			return -1;*/
	}
}
