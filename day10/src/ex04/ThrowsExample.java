package ex04;

public class ThrowsExample {
	public static void main(String[] args) throws ClassNotFoundException{
		try {
			findClass();
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			System.out.println("Ŭ������ �������� �ʽ��ϴ�");
		}
	}
		public static void findClass() throws ClassNotFoundException{
			Class clazz = Class.forName("java.lang.String2");
	}
}
