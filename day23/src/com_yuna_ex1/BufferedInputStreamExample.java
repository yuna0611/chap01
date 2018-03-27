package com_yuna_ex1;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class BufferedInputStreamExample {
	public static void main(String[] args) throws Exception {
		long start = 0;
		long end = 0;
		
		FileInputStream fis1 = new FileInputStream(
				"src/com_yuna_ex1/apc.jpg");
		start = System.currentTimeMillis();
		while(fis1.read()!= -1) {}
		end = System.currentTimeMillis();
		System.out.println("������� �ʾ��� �� : "+(end-start)+"ms");
		fis1.close();

		FileInputStream fis2 = new FileInputStream(
				"src/com_yuna_ex1/apc.jpg");
		BufferedInputStream bis = new BufferedInputStream(fis2);
		start = System.currentTimeMillis();
		while(bis.read()!= -1) {}
		end = System.currentTimeMillis();
		System.out.println("������� �� : "+(end-start)+"ms");
		bis.close();
		fis2.close();
	}
}
