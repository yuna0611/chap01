package com.chobo.ex4;

public class Result {
	int accmValue=1;
	synchronized void addValue(int value) {
		accmValue*=value;
	}
}
