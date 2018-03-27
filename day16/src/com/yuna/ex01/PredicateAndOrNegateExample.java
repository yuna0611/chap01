package com.yuna.ex01;

import java.util.function.IntPredicate;

public class PredicateAndOrNegateExample {
	public static void main(String[] args) {
		IntPredicate predicateA = a->a%2==0;
		IntPredicate predicateB = a->a%3==0;
		
		IntPredicate predicateAB;
		boolean result;
		
		predicateAB=predicateA.and(predicateB);
		result=predicateAB.test(9);
		System.out.println("9�� 2�� 3�� ����Դϱ�?"+result);

		predicateAB=predicateA.or(predicateB);
		result=predicateAB.test(9);
		System.out.println("9�� 2�� 3�� ����Դϱ�?"+result);

		predicateAB=predicateA.negate();
		result=predicateAB.test(9);
		System.out.println("9�� Ȧ�� �Դϱ�?"+result);
	}
}
