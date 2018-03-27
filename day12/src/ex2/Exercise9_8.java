package ex2;


/*
 * 메소드명 round
 * 기능 : 주어진 값을 반올림하여, 소수점 이하 n 자리의 값을 반환한다.
 * 예를 들어 n의 값이 3이면, 소수점 4 째 자리에서 반올림하여 소수점 이하 3자리의 수를 반환한다.
 * 반환타입 : double
 * 매개변수 : double d  - 변환할 값
 * int n - 반올림한 결과의 소수점 자리

 *[Hint]Math.round()와 Math.pow()를 이용하라.
 */

public class Exercise9_8 {
	static double round(double d, int n) {
		//주어진 숫자에 *10, 100, 1000...
		//그리고 다시 나누기/10, 100, 1000...
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
