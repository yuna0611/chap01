package day08_07;

public class Building {
	LiftableImpl lift = new LiftableImpl();

	public void liftOff() {
		lift.liftOff();
	public void move(int x, int y){
			lift.move(x, y);
		}
	public void stop() {
			lift.stop();
		}
		public void land() {
			lift.land();
		} 
	}
}
