package exam_01;

public class Soldier {
	public String name; 			//�̸�
	public String rank;
	public int healthPower; //�ǰ���
	
	public Soldier() {
		System.out.println("I'm created");
		this.healthPower=100;	//�����ڸ� Ȱ���Ͽ� �ʱ�ȭ
	}
	
	public Soldier(String name2, String rank2) {
		this();
		this.name=name2;
		this.rank=rank2;
	}

	//���
	//�̸� ��â�ϱ�
	public String getName() {
		return name;
	}
	
	//��� ��â�ϱ�
	public String getRank() {
		return rank;
	}
	
	public int getHP() {
		return healthPower;
	}
	
	public void eat() {
		System.out.println("�� �Ծ����ϴ�");
		
	}
	
}
