package day08_01;

public class Buyer {	//��, ������ ��� ���
	int money=1000;	//�����ݾ�
	int bonusPoint = 0;	//���ʽ�����
	
	void buy(Product p) {
		if(p instanceof Tv) {
			Tv t = (Tv)p;
			System.out.println("[TvŸ��]");
		}
		if(p instanceof Computer) {
			Computer c = (Computer)p;
			System.out.println("[ComputerŸ��]");
		}
		if(p instanceof Audio) {
			Audio a = (Audio)p;
			System.out.println("[AudioŸ��]");
		}
		
		if(money<p.price) {
			System.out.println("�ܾ��� �����Ͽ� ������ �� �� �����ϴ�.\n");
			return;
		}
		money-=p.price;
		bonusPoint+=p.bonusPoint;
		System.out.println(p+"��/�� �����ϼ̽��ϴ�.\n");
	}
}
