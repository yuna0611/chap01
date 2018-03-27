package day06.exam02;

public class KumhoTire extends Tire{
	public KumhoTire(String location, int maxRotation, String brand) {
		super(location, maxRotation);
		this.brand=brand;
	}

	@Override
	public boolean roll() {
		++accumulatedRotation;
		if(accumulatedRotation<maxRotation) {
			System.out.println(location+"KumhoTire ¼ö¸í : "+ (maxRotation-accumulatedRotation)+"È¸");
			return true;
		}else {
			System.out.println("*** " + location +"KumhoTire ÆãÅ© ***");
			return false;
		}
	}

}
