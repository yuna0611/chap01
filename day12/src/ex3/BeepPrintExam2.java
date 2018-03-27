package ex3;

import java.awt.Toolkit;

public class BeepPrintExam2 {
	public static void main(String[] args) {
//		Runnable beepTask = new BeepTask();
//	Thread thread = new Thread(beepTask);
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				Toolkit toolkit = Toolkit.getDefaultToolkit();
				for (int i = 0; i < 5; i++) {
					toolkit.beep();
					try {Thread.sleep(500);} catch (Exception e) {}
				}
			}
		});
		thread.start();
		for (int i = 0; i < 5; i++) {
			System.out.println("¶ò");
			try { Thread.sleep(500); } catch (Exception e) { }
		}
	}
} 


//class BeepTask implements Runnable{
	/*public void run() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		for (int i = 0; i < 5; i++) {
			toolkit.beep();
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}*/
	
	
