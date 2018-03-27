package day08_07;

public class LiftableImpl implements Liftable{
	public void liftOff() {
		System.out.println("LiftOff");
	}
	public void move(int x, int y) {
		System.out.println("Move");
	}
	public void stop() {
		System.out.println("Stop");
	}
	public void land() {
		System.out.println("Land");
	}
}
