package ex04;

public class TryCatchFinallyExample {
	public static void main(String[] args) {
		try {
			Class clazz = Class.forName("java.lang.Stripg2");
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			System.out.println("Ŭ������ �������� �ʽ��ϴ�");
		}
	}
}
