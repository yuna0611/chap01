package exam_01;

public class Soldier {
	public String name; 			//이름
	public String rank;
	public int healthPower; //건강도
	
	public Soldier() {
		System.out.println("I'm created");
		this.healthPower=100;	//생성자를 활용하여 초기화
	}
	
	public Soldier(String name2, String rank2) {
		this();
		this.name=name2;
		this.rank=rank2;
	}

	//기능
	//이름 복창하기
	public String getName() {
		return name;
	}
	
	//계급 복창하기
	public String getRank() {
		return rank;
	}
	
	public int getHP() {
		return healthPower;
	}
	
	public void eat() {
		System.out.println("밥 먹었습니다");
		
	}
	
}
