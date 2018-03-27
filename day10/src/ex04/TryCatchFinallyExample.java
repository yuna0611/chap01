package ex04;

public class TryCatchFinallyExample {
	public static void main(String[] args) {
		try {
			Class clazz = Class.forName("java.lang.Stripg2");
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			System.out.println("클래스가 존재하지 않습니다");
		}
	}
}
