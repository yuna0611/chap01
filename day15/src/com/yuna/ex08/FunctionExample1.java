package com.yuna.ex08;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;

public class FunctionExample1 {
	private static List<Student> list = Arrays.asList(
		new Student("������", 100, 100),
		new Student("ȫ�浿", 95	, 93)
	);
	
	public static void printString( Function<Student, String> function) {
		for(Student student : list) {
			System.out.println(function.apply(student)+" ");
		}
		System.out.println();
	}
	
	public static void printInt( ToIntFunction<Student> function) {
		for(Student student : list) {
			System.out.println(function.applyAsInt(student)+" ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		System.out.println("[�л� �̸�]");
		printString(t->t.getName());

		System.out.println("[���� ����]");
		printInt(t->t.getEnglishScore());

		System.out.println("[���� ����]");
		printInt(t->t.getMathScore());
		
	}
}
