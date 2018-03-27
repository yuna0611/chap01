package ex3;

public class ThreadNameExample {
	public static void main(String[] args) {
		Thread mainThread = Thread.currentThread();
		System.out.println("���α׷� ���� ������ �̸� : "+mainThread.getName());
		
		ThreadA threadA = new ThreadA();
		System.out.println("�۾� ������ �̸� : "+threadA.getName());
		threadA.start();

		Runnable threadB=new ThreadB();
		Thread thread = new Thread(threadB);
		System.out.println("�۾� ������ �̸� : "+thread.getName());
		thread.start();
		
	}
}


class ThreadA extends Thread{
	public ThreadA() {
		setName("ThreadA");
	}
	
	public void run() {
		for (int i = 0; i < 1; i++) {
			System.out.println(getName()+"�� ����� ����");
		}
	}
}

class ThreadB implements Runnable{
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName()+"�� ����� ����");
		}
	}

}

/*class ThreadB extends Thread{
	
	public void run() {
		for (int i = 0; i < 2; i++) {
			System.out.println(getName()+"�� ����� ����");
		}
	}
}
*/
