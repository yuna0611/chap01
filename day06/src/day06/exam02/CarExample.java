package day06.exam02;

public class CarExample {
	public static void main(String[] args) {
		Car car = new Car();
		Tire[] product = { new HankookTire("앞왼쪽", 15, "HankookTire"), new KumhoTire("앞오른쪽", 13, "KumhoTire"),
				new NexenTire("뒤왼쪽", 14, "NexenTire"), new MechelinTire("뒤오른쪽", 17, "MechelinTire") };

		for (int i = 1; i <= 5; i++) {
			int problemLocation = car.run();
			if (problemLocation != 0) {
				System.out.println(car.tires[problemLocation - 1].location + product[problemLocation-1].brand + "로 교체");
				car.tires[problemLocation - 1] = product[problemLocation - 1];
			}
			System.out.println("------------------------");
		}
	}
}