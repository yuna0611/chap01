package day08_06;

public class Medic extends GroundUnit implements Repairable2{
	Medic(){
		super(150);
		hitPoint = MAX_HP;
	}
	
	void repair(Repairable2 r) {
		if(r instanceof Unit) {
			Unit u = (Unit)r;
			while(u.hitPoint!=u.MAX_HP) {
				u.hitPoint++;
			}
			System.out.println(u.toString()+"의 수리가 끝났습니다");
		}
	}

}