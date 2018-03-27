package com_yuna_ex1;

import java.io.FileInputStream;

public class FileInputStreamExample {
	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream(
					"src/com_yuna_ex1/FileInputStreamExample.java");
			
			int data;
			while((data=fis.read()) != -1) {
				System.out.write(data);
			}
			fis.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
