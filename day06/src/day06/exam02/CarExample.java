package day06.exam02;

public class CarExample {
	public static void main(String[] args) {
		Car car = new Car();
		Tire[] product = { new HankookTire("�տ���", 15, "HankookTire"), new KumhoTire("�տ�����", 13, "KumhoTire"),
				new NexenTire("�ڿ���", 14, "NexenTire"), new MechelinTire("�ڿ�����", 17, "MechelinTire") };

		for (int i = 1; i <= 5; i++) {
			int problemLocation = car.run();
			if (problemLocation != 0) {
				System.out.println(car.tires[problemLocation - 1].location + product[problemLocation-1].brand + "�� ��ü");
				car.tires[problemLocation - 1] = product[problemLocation - 1];
			}
			System.out.println("------------------------");
		}
	}
}