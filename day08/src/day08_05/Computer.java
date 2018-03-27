package day08_05;

public class Computer implements RemoteControl {
	private int volume;

	public void turnOn() {
		System.out.println("Computer¸¦ ÄÕ´Ï´Ù");
	}

	public void turnOff() {
		System.out.println("Computer¸¦ ²ü´Ï´Ù");
	}

	public void setVolume(int volume) {
		if (volume > RemoteControl.MAX_VOLUME)
			this.volume = RemoteControl.MAX_VOLUME;
		else if (volume < RemoteControl.MIN_VOLUME)
			this.volume = RemoteControl.MIN_VOLUME;
		else
			this.volume = volume;
		
		System.out.println("ÇöÀç Computer º¼·ý : "+volume);
	}
}
