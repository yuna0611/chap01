package ex7;

public class DataBox {
	private String data;

	public synchronized String getData() {
		if(this.data==null) {
			try {
				wait();
			} catch (InterruptedException e) {}
		}
		String returnValue = data;
		System.out.println("ConsumerThread�� ���� ������ : "+returnValue);
		data=null;
		notify();
		return returnValue;
	}

	public synchronized void SetData(String data) {
		if(this.data!=null) {
			try {
				wait();
			} catch (InterruptedException e) {}
		}
		this.data=data;
		System.out.println("ProducerThread�� ������ ������ : "+data);
		notify();
	}
}
