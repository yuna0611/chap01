package day08_05;

public class RemoteControlExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RemoteControl rc = RemoteControlManager.getControl("TV");
		rc.turnOn();
		rc.setVolume(5);
		rc.turnOff();
		rc = RemoteControlManager.getControl("Audio");
		rc.turnOn();
		rc.setVolume(6);
		rc.turnOff();
		rc = RemoteControlManager.getControl("Computer");
		rc.turnOn();
		rc.setVolume(8);
		rc.turnOff();
	}
}
