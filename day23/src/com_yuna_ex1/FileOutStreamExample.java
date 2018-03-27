package com_yuna_ex1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class FileOutStreamExample {
	public static void main(String[] args) throws Exception {
		String originalFileName = "src/com_yuna_ex1/apc.jpg";
		String targetFileName = "C:/Temp/apc.jpg";
		
		FileInputStream fis=new FileInputStream(originalFileName);
		FileOutputStream fos = new FileOutputStream(targetFileName);
		
		int readByteNo;
		byte[] readBytes = new byte[100];
		while((readByteNo=fis.read(readBytes))!=-1) {
			fos.write(readBytes,0,readByteNo);
		}
		
		fos.flush();
		fos.close();
		fis.close();
		
		System.out.println("복사가 잘 되었습니다.");
	}
}
