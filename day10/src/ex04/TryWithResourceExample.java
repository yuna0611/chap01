package ex04;

import java.io.FileInputStream;

public class TryWithResourceExample {
	public static void main(String[] args) {
		try(FileInputStream fis = new FileInputStream("file.txt")) {
			fis.read();
			throw new Exception();
		} catch (Exception e) {
			// TODO: handle excepton
			System.out.println("���� ó�� �ڵ尡 ����Ǿ����ϴ�");
		}
	}
}
