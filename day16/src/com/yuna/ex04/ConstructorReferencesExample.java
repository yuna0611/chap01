package com.yuna.ex04;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class ConstructorReferencesExample {
	public static void main(String[] args) {
		
		
		Supplier<Member> function0 = Member ::new;
		Member member0 = function0.get();
		
		Function<String, Member> function1 = Member ::new;
		Member member1 = function1.apply("angel");
		
		BiFunction<String, String, Member> function2 = Member::new;
		Member member2 = function2.apply("Ω≈√µªÁ", "angel");
		
		
	}
}
