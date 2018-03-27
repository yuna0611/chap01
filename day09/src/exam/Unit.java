package exam;

import exam_01.Commander;
import exam_01.Cook;
import exam_01.Private;
import exam_01.Scout;
import exam_01.Sniper;

public class Unit {
	public static void main(String[] args) {
		
		
		//�� ��ü�� ����
		Scout watchMan = new Scout();
		Private attacker = new Private("��","�ϻ�",50);
		Private attacker2 = new Private("�׸���","�߻�",30);
		Commander boss = new Commander();
		Cook cook = new Cook();
		Sniper sniper = new Sniper();
		
		//�� ��ü���� ��� ��ü�� ���۷����� ����
		boss.addAttacker(attacker);
		boss.addAttacker(attacker2);
		
		boss.setCook(cook);
		watchMan.setCommander(boss);
		attacker.setCommander(boss);
		attacker2.setCommander(boss);
		
		cook.registerSoldier(boss);
		cook.registerSoldier(attacker);
		cook.registerSoldier(attacker2);
		cook.registerSoldier(watchMan);
		cook.registerSoldier(cook);
		cook.registerSoldier(sniper);
		
		sniper.setCommander(boss);
		
		
		//ô�ĺ� ��ü���� ���ø� ��Ŵ
		//���� �� ����� ����ڷκ��� �Է��� �޴� ��ƾ
		watchMan.watch();
		
	}
}
