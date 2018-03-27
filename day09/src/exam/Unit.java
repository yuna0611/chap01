package exam;

import exam_01.Commander;
import exam_01.Cook;
import exam_01.Private;
import exam_01.Scout;
import exam_01.Sniper;

public class Unit {
	public static void main(String[] args) {
		
		
		//각 객체를 생성
		Scout watchMan = new Scout();
		Private attacker = new Private("존","하사",50);
		Private attacker2 = new Private("그리샴","중사",30);
		Commander boss = new Commander();
		Cook cook = new Cook();
		Sniper sniper = new Sniper();
		
		//각 객체에게 상대 객체의 레퍼런스를 셋팅
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
		
		
		//척후병 객체에게 감시를 시킴
		//실제 이 기능은 사용자로부터 입력을 받는 루틴
		watchMan.watch();
		
	}
}
