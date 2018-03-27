package ex10;

public class Customer implements Runnable {
	private Table table;
	private String food;
	private String name;
	
	public Customer(Table table, String food, String name) {
		this.table = table;
		this.food = food;
		this.name = name;
	}

	public void run() {
		Thread.currentThread().setName(name);
		while(true) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {}
			String name = Thread.currentThread().getName();
			
			table.remove(food);
			System.out.println(name+" ate a "+food);
		}
	}
/*	public void run() {
		while(true) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {}
			
			String name = Thread.currentThread().getName();
			
			if(eatFood())
				System.out.println(name+"ate a "+food);
			else
				System.out.println(name+"failed to eat :-(");
		}
	}
	
	boolean eatFood() {
		return table.remove(food);
	}
*/
} 
