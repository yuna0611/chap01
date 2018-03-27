package day06.exam02;

public class NexenTire extends Tire{

	public NexenTire(String location, int maxRotation, String brand) {
		super(location, maxRotation);
		this.brand=brand;
	}

	@Override
	public boolean roll() {
		++accumulatedRotation;
		if(accumulatedRotation<maxRotation) {
			System.out.println(location+"NexenTire ���� : "+ (maxRotation-accumulatedRotation)+"ȸ");
			return true;
		}else {
			System.out.println("*** " + location +"NexenTire ��ũ ***");
			return false;
		}
	}
}
