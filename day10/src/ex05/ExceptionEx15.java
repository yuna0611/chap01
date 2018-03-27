package ex05;

import java.io.File;
import java.io.IOException;

public class ExceptionEx15 {
	public static void main(String[] args) {
		// command line���� �Է¹��� ���� �̸����� ���� ������ �����Ѵ�.
		try {
			File f = createFile(args[0]);
			System.out.println(f.getName() + "������ ���������� �����Ǿ����ϴ�");
		} catch (Exception e) {
			try {
				File f = createFile("�������.txt");
				System.out.println(f.getName() + "������ ���������� �����Ǿ����ϴ�");
			} catch (Exception ee) {
				// TODO: handle exception
				System.out.println(ee.getMessage()+"�ٽ� �Է��� �ֽñ� �ٶ��ϴ�");
				}
		}
	}
	// main �޼ҵ��� ��

	static File createFile(String fileName) throws Exception{
		if(fileName == null || fileName.equals(""))
			throw new Exception("���� �̸��� ��ȿ���� �ʽ��ϴ�.");
		File f = new File(fileName);	//File Ŭ������ ��ü�� �����.
		f.createNewFile();	//������ ��ü�� �̿��ؼ� ������ �����Ѵ�.
		return f;
	}
}
/*	static File createFile(String fileName) {
		try {
			if(fileName == null || fileName.equals(""))
				throw new Exception("���� �̸��� ��ȿ���� �ʽ��ϴ�.");
		} catch (Exception e) {
			// fileName�� �������� ���, ���� �̸��� "�������.txt."�� �Ѵ�.
			fileName="�������.txt";
		}finally {
			File f = new File(fileName);	//File Ŭ������ ��ü�� �����.
			createNewFile(f);	//������ ��ü�� �̿��ؼ� ������ �����Ѵ�.
			return f;
		}
	}
	//createFile�޼ҵ��� ��
	
	static void createNewFile(File f) {
		try {
			f.createNewFile();	//���� ����
		} catch (Exception e) {
			// createNewFile�޼ҵ��� ��
		}
	}*/
/*package ex05;

import java.io.File;

public class ExceptionEx15 {
	public static void main(String[] args) {
		//command line���� �Է¹��� ���� �̸����� ���� ������ �����Ѵ�.
		File f = createFile(args[0]);
		System.out.println(f.getName()+"������ ���������� �����Ǿ����ϴ�");
	}
	//main �޼ҵ��� ��
	
	static File createFile(String fileName) {
		try {
			if(fileName == null || fileName.equals(""))
				throw new Exception("���� �̸��� ��ȿ���� �ʽ��ϴ�.");
		} catch (Exception e) {
			// fileName�� �������� ���, ���� �̸��� "�������.txt."�� �Ѵ�.
			fileName="�������.txt";
		}finally {
			File f = new File(fileName);	//File Ŭ������ ��ü�� �����.
			createNewFile(f);	//������ ��ü�� �̿��ؼ� ������ �����Ѵ�.
			return f;
		}
	}
	//createFile�޼ҵ��� ��
	
	static void createNewFile(File f) {
		try {
			f.createNewFile();	//���� ����
		} catch (Exception e) {
			// createNewFile�޼ҵ��� ��
		}
	}
}
*/