package day06.exam02;

public class Tire {
	public int maxRotation;
	public int accumulatedRotation;
	public String location;
	String brand;

	public Tire(String location, int maxRotation) {
		this.location = location;
		this.maxRotation = maxRotation;
	}


	public boolean roll() {
		++accumulatedRotation;
		if (accumulatedRotation < maxRotation) {
			System.out.println(location + "Tire ���� : " + (maxRotation - accumulatedRotation) + "ȸ");
			return true;
		}else {
			System.out.println("***"+location+"Tire ��ũ ***");
			return false;
		}
	}
}
