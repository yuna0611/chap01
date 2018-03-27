package ex3;

import java.awt.Toolkit;

public class BeepPrintExam01 {
	public static void main(String[] args) {
	Thread thread = new Thread();
		thread.start();
		for (int i = 0; i < 5; i++) {
			System.out.println("¶ò");
			try { Thread.sleep(500); } catch (Exception e) { }
		}
	}
} 


class BeepTask extends Thread{
	public void run() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		for (int i = 0; i < 5; i++) {
			toolkit.beep();
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}	
	
