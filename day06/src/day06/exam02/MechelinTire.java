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
			System.out.println(location+"MechelinTire ¼ö¸í : "+ (maxRotation-accumulatedRotation)+"È¸");
			return true;
		}else {
			System.out.println("*** " + location +"MechelinTire ÆãÅ© ***");
			return false;
		}
	}
	
}
