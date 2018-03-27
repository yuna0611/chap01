package day06;

class Tv{
	boolean power;
	int channel;
	
	void power() {
		power=!power;
	}
	void channelUp() {
		channel++;
	}
	void channelDown() {
		channel--;
	}
}

class CaptionTv extends Tv{
	boolean caption;
	void displayCapotion(String text) {
		if(caption) {
			System.out.println(text);
		}
	}
}
public class Ex05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CaptionTv ctv = new CaptionTv();
		ctv.channel=10;
		ctv.channelUp();
		System.out.println(ctv.channel);
		ctv.displayCapotion("Hello World");
		ctv.caption=true;
		ctv.displayCapotion("Hello World");
	}

}
