package day08_05;

public class RemoteControlManager {
	public static RemoteControl getControl(String type){
		if (type.equals("TV"))
			return new Television();
		else if(type.equals("Audio"))
			return new Audio();
		else
			return new Computer();
	}
}

