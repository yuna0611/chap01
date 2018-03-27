package ex9;

public class ThreadEx10 implements Runnable{
	static boolean autoSave = false;
	
	public static void main(String[] args) {
		Thread t = new Thread(new ThreadEx10());
		t.setDaemon(true);
		t.start();
		
		for (int i = 1; i <=10; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {}
				System.out.println();
				// TODO: handle exception
				
				if(i==5)
					autoSave = true;
			}
			System.out.println("프로그램을 실행합니다");
		}
	public void run() {
		while(true) {
			try {
				Thread.sleep(3*1000);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
			if(autoSave)
				autoSave();
		}
	}
	
	public void autoSave() {
		System.out.println("작업파일이 자동저장되었습니다");
	}
}


