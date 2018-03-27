package ex7;

public class ConsumerThread extends Thread{
	private DataBox  dataBox;

	public ConsumerThread(DataBox dataBox) {
		this.dataBox = dataBox;
	}

	@SuppressWarnings("unused")
	@Override
	public void run() {
		for (int i = 1; i <= 3; i++) {
			String data = dataBox.getData();
		}
	}
	
}
