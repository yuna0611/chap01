package com_yuna_ex1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class PrintStreamExample {
	public static void main(String[] args) throws Exception {
		FileOutputStream fos = new FileOutputStream("C:/Temp/file.txt");
		PrintStream ps = new PrintStream(fos);
		
		ps.println("[������ ���� ��Ʈ��]");
		ps.print("��ġ ");
		ps.println("�����Ͱ� ����ϴ� ��ó�� ");
		ps.println("�����͸� ����մϴ�.");
		
		ps.flush();
		ps.close();
		fos.close();
	}
}
