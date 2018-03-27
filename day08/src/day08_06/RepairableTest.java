package day08_06;


public class RepairableTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tank tank = new Tank();
		Dropship dropship = new Dropship();
		Marine marine = new Marine();
		Medic medic = new Medic();
		SCV scv = new SCV();
		
		scv.repair(tank);
		scv.repair(dropship);
		medic.repair(marine);
	}
}

