package ex10;

public class Cook implements Runnable{
	private Table table;
	private String name;

	//������ �ʱ�ȭ
	Cook(Table table, String name) {
		this.table = table;
		this.name = name;
	}

	public void run() {
		Thread.currentThread().setName(name);
		while(true) {
			//������ �丮�� �ϳ� �����ؼ� TABLE�� �߰��Ѵ�.
			int idx = (int)(Math.random()*table.dishNum());
			table.add(table.dishNames[idx]);
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
	}
}
