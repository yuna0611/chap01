package ex8;

public class PrintThread2 extends Thread {
	public void run() {
			while(true) {
				System.out.println("���� ��");
				if(Thread.interrupted())
					break;
		}
		System.out.println("�ڿ� ����");
		System.out.println("���� ����");
	}
}
		
/*	public void run() {
		try {
			while(true) {
				System.out.println("���� ��");
				Thread.sleep(1);
			}
		} catch (InterruptedException e) {
		}
		System.out.println("�ڿ� ����");
		System.out.println("���� ����");
	}
*/
