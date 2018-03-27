package day06.exam02;

public class MechelinTire extends Tire{

	public MechelinTire(String location, int maxRotation, String brand) {
		super(location, maxRotation);
		this.brand=brand;
	}

	@Override
	public boolean roll() {
		++accumulatedRotation;
		if(accumulatedRotation<maxRotation) {
			System.out.println(location+"MechelinTire ���� : "+ (maxRotation-accumulatedRotation)+"ȸ");
			return true;
		}else {
			System.out.println("*** " + location +"MechelinTire ��ũ ***");
			return false;
		}
	}
	
}
