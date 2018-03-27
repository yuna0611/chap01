package exam_01;

public class Private extends Soldier{
	protected int bulletNum; // 총알의 수
	private Commander myBoss;//지휘관 객체에게 메세지를 전달하기 위한 레퍼런스 추가
	
	public Private(){}
	
	//생성자 오버로딩
	public Private(String name, String rank, int i) {
		this(name,rank);
		this.bulletNum=i;
	}
	
	public Private(String name, String rank) {
		super(name,rank);
		this.bulletNum=20;
	}

	public void setCommander(Commander man) {//소총수 객체의 레퍼런스를 셋팅하기 위한 메소드 추가
		myBoss=man;
	}
	
	//총알 10개
	public void attack(int num) {
		for (int idx = 0; idx < num; idx++) {
			bulletNum--;
			healthPower--;
			if(bulletNum<=0)
				myBoss.listenPrivate(this);
		}
		System.out.println("<공격>"+super.rank+" : 건강도("+healthPower+"), 총알수 ("+bulletNum+")");
	}
	
	//한번의 공격에 총알 5개 사용, 건강도 5 감소
	public void attack() {
		for (int idx = 0; idx < 5; idx++) {
			bulletNum--;
			healthPower--;
			if(bulletNum<=0)
				myBoss.listenPrivate(this);
		}
		System.out.println("<공격>"+super.rank+" : 건강도("+healthPower+"), 총알수 ("+bulletNum+")");
	}
	
	
	//한번의 방어에 총알 1개 사용, 건강도 10 감소
	public void defence() {
		bulletNum-=1;
		healthPower-=10;
		if(bulletNum<=0)
			myBoss.listenPrivate(this);
		System.out.println("<방어>"+rank+" : 건강도("+healthPower+"), 총알수 ("+bulletNum+")");
	}
	
	//총알을 재장전한다.
	public void reload(int num) {
		bulletNum+=num;
	}
	
	public void eat() {
		this.healthPower+=1;
		System.out.println("병사 밥 먹음");
	}
}
