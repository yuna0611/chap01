package exam_01;

import java.util.Vector;

public class Cook extends Soldier{
	private Vector soldierList;
	//�̸� ��â
	public Cook() {
		soldierList=new Vector();
	}
	
	//�Ļ� �غ�
	public void cooking() {
		for (int idx = 0; idx < soldierList.size(); idx++) {
			Soldier man = (Soldier)soldierList.get(idx);
			man.eat();
		}
	}
	public void registerSoldier(Soldier s) {
		soldierList.add(s);
	}
}
