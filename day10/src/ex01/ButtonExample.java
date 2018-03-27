package ex01;

public class ButtonExample {
	public static void main(String[] args) {
		Button btn = new Button();
		
		btn.setOnCliCkListener(new CallListener());
		btn.touch();

		btn.setOnCliCkListener(new MessageListener());
		btn.touch();
	}
}
