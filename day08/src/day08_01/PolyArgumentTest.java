package day08_01;

public class PolyArgumentTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Buyer b = new Buyer();
		b.buy(new Tv());
		b.buy(new Computer());
		b.buy(new Audio());
		
		System.out.println("���� ���� ���� "+b.money+"���� �Դϴ�.");
		System.out.println("���� ���ʽ� ������ "+b.bonusPoint+"�� �Դϴ�.");
	}
}
