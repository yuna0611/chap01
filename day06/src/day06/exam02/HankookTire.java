package day06.exam02;

public class HankookTire extends Tire{
	public HankookTire(String location, int maxRotation, String brand) {
		super(location, maxRotation);
		this.brand=brand;
	}

	@Override
	public boolean roll() {
		++accumulatedRotation;
		if(accumulatedRotation<maxRotation) {
			System.out.println(location+"HankookTire ���� : "+ (maxRotation-accumulatedRotation)+"ȸ");
			return true;
		}else {
			System.out.println("*** " + location +"HankookTire ��ũ ***");
			return false;
		}
	}
	
	
}


