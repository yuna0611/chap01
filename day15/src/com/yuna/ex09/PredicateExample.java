package com.yuna.ex09;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateExample {
	private static List<Student> list = Arrays.asList(
		new Student("노유나", "여자", 100),	
		new Student("홍길동", "남자", 95),	
		new Student("김자바", "여자", 85),	
		new Student("노자바", "남자", 60)	
		);
	
	public static double avg(Predicate<Student> predicate) {
		int count = 0, sum=0;
		for(Student student : list) {
			if(predicate.test(student)) {
				count++;
				sum+=student.getScore();
			}
		}
		return (double)sum/count;
	}
	
	public static void main(String[] args) {
		double maleAvg = avg(t->t.getSex().equals("남자"));
		System.out.println("남자 평균 점수 : "+maleAvg);

		double femaleAvg = avg(t->t.getSex().equals("여자"));
		System.out.println("남자 평균 점수 : "+femaleAvg);
	}
}
