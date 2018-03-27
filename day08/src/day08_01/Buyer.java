package day08_01;

public class Buyer {	//고객, 물건을 사는 사람
	int money=1000;	//소유금액
	int bonusPoint = 0;	//보너스점수
	
	void buy(Product p) {
		if(p instanceof Tv) {
			Tv t = (Tv)p;
			System.out.println("[Tv타입]");
		}
		if(p instanceof Computer) {
			Computer c = (Computer)p;
			System.out.println("[Computer타입]");
		}
		if(p instanceof Audio) {
			Audio a = (Audio)p;
			System.out.println("[Audio타입]");
		}
		
		if(money<p.price) {
			System.out.println("잔액이 부족하여 물건을 살 수 없습니다.\n");
			return;
		}
		money-=p.price;
		bonusPoint+=p.bonusPoint;
		System.out.println(p+"을/를 구입하셨습니다.\n");
	}
}
