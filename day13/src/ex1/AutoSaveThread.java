package ex1;

public class AutoSaveThread extends Thread{
	public void save() {
		System.out.println("작업 내용을 저장");
	}

	@Override
	public void run() {
		super.run();
		while(true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO: handle exception
				break;
			}
			save();
		}
	}
	
	
}
