package com.yuna.ex02;

import java.util.Comparator;

public class Ascending implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		/*if(o2.ban<o1.ban) {
			return 1;
		}else if(o2.ban==o1.ban) {
			if(o2.no<o1.no)
				return 1;
			else if(o2.no==o1.no)
				return 0;
			else
				return -1;
		}else
			return -1;*/
		
		int result = o1.ban-o2.ban;
		if(result==0)
			return o1.no-o2.no;
		
		return result;
	}
}
