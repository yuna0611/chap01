package ex3;

public class ThreadNameExample {
	public static void main(String[] args) {
		Thread mainThread = Thread.currentThread();
		System.out.println("프로그램 시작 스레드 이름 : "+mainThread.getName());
		
		ThreadA threadA = new ThreadA();
		System.out.println("작업 스레드 이름 : "+threadA.getName());
		threadA.start();

		Runnable threadB=new ThreadB();
		Thread thread = new Thread(threadB);
		System.out.println("작업 스레드 이름 : "+thread.getName());
		thread.start();
		
	}
}


class ThreadA extends Thread{
	public ThreadA() {
		setName("ThreadA");
	}
	
	public void run() {
		for (int i = 0; i < 1; i++) {
			System.out.println(getName()+"가 출력한 내용");
		}
	}
}

class ThreadB implements Runnable{
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName()+"가 출력한 내용");
		}
	}

}

/*class ThreadB extends Thread{
	
	public void run() {
		for (int i = 0; i < 2; i++) {
			System.out.println(getName()+"가 출력한 내용");
		}
	}
}
*/
