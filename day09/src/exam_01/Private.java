package exam_01;

public class Private extends Soldier{
	protected int bulletNum; // �Ѿ��� ��
	private Commander myBoss;//���ְ� ��ü���� �޼����� �����ϱ� ���� ���۷��� �߰�
	
	public Private(){}
	
	//������ �����ε�
	public Private(String name, String rank, int i) {
		this(name,rank);
		this.bulletNum=i;
	}
	
	public Private(String name, String rank) {
		super(name,rank);
		this.bulletNum=20;
	}

	public void setCommander(Commander man) {//���Ѽ� ��ü�� ���۷����� �����ϱ� ���� �޼ҵ� �߰�
		myBoss=man;
	}
	
	//�Ѿ� 10��
	public void attack(int num) {
		for (int idx = 0; idx < num; idx++) {
			bulletNum--;
			healthPower--;
			if(bulletNum<=0)
				myBoss.listenPrivate(this);
		}
		System.out.println("<����>"+super.rank+" : �ǰ���("+healthPower+"), �Ѿ˼� ("+bulletNum+")");
	}
	
	//�ѹ��� ���ݿ� �Ѿ� 5�� ���, �ǰ��� 5 ����
	public void attack() {
		for (int idx = 0; idx < 5; idx++) {
			bulletNum--;
			healthPower--;
			if(bulletNum<=0)
				myBoss.listenPrivate(this);
		}
		System.out.println("<����>"+super.rank+" : �ǰ���("+healthPower+"), �Ѿ˼� ("+bulletNum+")");
	}
	
	
	//�ѹ��� �� �Ѿ� 1�� ���, �ǰ��� 10 ����
	public void defence() {
		bulletNum-=1;
		healthPower-=10;
		if(bulletNum<=0)
			myBoss.listenPrivate(this);
		System.out.println("<���>"+rank+" : �ǰ���("+healthPower+"), �Ѿ˼� ("+bulletNum+")");
	}
	
	//�Ѿ��� �������Ѵ�.
	public void reload(int num) {
		bulletNum+=num;
	}
	
	public void eat() {
		this.healthPower+=1;
		System.out.println("���� �� ����");
	}
}
