package day08_06;

public class Marine extends GroundUnit implements Repairable2{
	Marine(){
		super(40);
		hitPoint = MAX_HP;
	}

	@Override
	public String toString() {
		return "Marine";
	}
	
}
