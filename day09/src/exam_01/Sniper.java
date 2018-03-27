package exam_01;

public class Sniper extends Private implements Sniping{
	
	public Sniper() {
	}
	
	Sniper(String name, String rank, int i) {
		this(name,rank);
		this.bulletNum=i;
	}
	public Sniper(String name, String rank) {
		super(name, rank);
		this.bulletNum=10;
	}


	@Override
	public void Shoot() {
		// TODO Auto-generated method stub
		if(bulletNum>0) {
			bulletNum--;
			System.out.println("����");
		}else {
			System.out.println("���� ����");
		}
	}
}
