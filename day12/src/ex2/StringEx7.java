package ex2;

public class StringEx7 {
	public static void main(String[] args) {
		String fullName="Yuna.NO";
		
		//fullName���� '.'�� ��ġ ã��
		int index = fullName.indexOf('.');
		
		//fullName�� ù���� ���ں��� '.'�� �ִ� ������ ���ڿ� ����
		String fileName = fullName.substring(0,index);
		
		//'.'�� ���� ���ں��� �����ؼ� ���ڿ��� ������ ����
		//fullName.substring(index+1, fullName.length());�� ����� ����
		String ext = fullName.substring(index+1);
		
		System.out.println(fullName+"�� �� ������ �̸���"+fileName);
		System.out.println(fullName+"�� ����"+ext);
	}
}
