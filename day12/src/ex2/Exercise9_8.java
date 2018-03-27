package ex2;


/*
 * �޼ҵ�� round
 * ��� : �־��� ���� �ݿø��Ͽ�, �Ҽ��� ���� n �ڸ��� ���� ��ȯ�Ѵ�.
 * ���� ��� n�� ���� 3�̸�, �Ҽ��� 4 ° �ڸ����� �ݿø��Ͽ� �Ҽ��� ���� 3�ڸ��� ���� ��ȯ�Ѵ�.
 * ��ȯŸ�� : double
 * �Ű����� : double d  - ��ȯ�� ��
 * int n - �ݿø��� ����� �Ҽ��� �ڸ�

 *[Hint]Math.round()�� Math.pow()�� �̿��϶�.
 */

public class Exercise9_8 {
	static double round(double d, int n) {
		//�־��� ���ڿ� *10, 100, 1000...
		//�׸��� �ٽ� ������/10, 100, 1000...
		double result =0;
		double cnt=Math.pow(10.0, n);
		
		
		result = (int) (d*cnt);
		result/=Math.round(cnt);
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(round(3.1415,1));
		System.out.println(round(3.1415,2));
		System.out.println(round(3.1415,3));
		System.out.println(round(3.1415,4));
		System.out.println(round(3.1415,5));
	}
}
