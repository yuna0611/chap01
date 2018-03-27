package ex10;

public class Cook implements Runnable{
	private Table table;
	private String name;

	//생성자 초기화
	Cook(Table table, String name) {
		this.table = table;
		this.name = name;
	}

	public void run() {
		Thread.currentThread().setName(name);
		while(true) {
			//임의의 요리를 하나 선택해서 TABLE에 추가한다.
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
