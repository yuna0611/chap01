package exam_01;

import java.util.Vector;

public class Cook extends Soldier{
	private Vector soldierList;
	//이름 복창
	public Cook() {
		soldierList=new Vector();
	}
	
	//식사 준비
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
