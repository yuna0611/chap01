package ex9;

import ex1.AutoSaveThread;

public class DaemonExample {
	public static void main(String[] args) {
		AutoSaveThread autoSaveThread = new AutoSaveThread();
		autoSaveThread.setDaemon(true);
		autoSaveThread.start();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		System.out.println("���ν����� ����");
	}
}
