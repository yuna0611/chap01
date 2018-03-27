package ex10;

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Table {
	String[] dishNames = { "donut", "donut", "burger" }; // donut�� �� ���� ���´�.
	final int MAX_FOOD = 6; // ���̺� ���� �� �ִ� �ִ� ������ ����

	private ArrayList<String> dishes = new ArrayList<>();
	
	private ReentrantLock lock = new ReentrantLock();
	private Condition forCook = lock.newCondition();
	private Condition forCust = lock.newCondition();
	
	public void add(String dish) {
		lock.lock();
		try {
			while(dishes.size()>=MAX_FOOD) {
				String name = Thread.currentThread().getName();
				System.out.println(name + " is waiting.");
				try {
					forCook.await();//wait() : Cook�����带 ��ٸ��� �Ѵ�.
					Thread.sleep(500);
			} catch (InterruptedException e) {}
		}
		dishes.add(dish);
		forCust.signal();
		System.out.println("Dishes : " + dishes.toString());
		}finally {
			lock.unlock();
		}
	}

	public void remove(String dishName) {
		lock.lock();
		String name = Thread.currentThread().getName();
		try {
			while(dishes.size()==0) {
				System.out.println(name + " is waiting.");
				try {
					forCust.await();//wait() : Cook�����带 ��ٸ��� �Ѵ�.
					Thread.sleep(500);
			} catch (InterruptedException e) {}
		}
			while(true) {
				for (int i = 0; i < dishes.size(); i++) {
					if (dishName.equals(dishes.get(i))) {
						dishes.remove(i);
						forCook.signal();
						return;
					}
				}//for�� ��
				
				try {
					System.out.println(name+" is waiting.");
					forCust.await();
					Thread.sleep(500);
				}catch (InterruptedException e) {}
			}//(while(true)
		}finally {
			lock.unlock();
		}
	}

	public int dishNum() {
		return dishNames.length;
	}
}
/*package ex10;

import java.util.ArrayList;

public class Table {
	String[] dishNames = { "donut", "donut", "burger" }; // donut�� �� ���� ���´�.
	final int MAX_FOOD = 6; // ���̺� ���� �� �ִ� �ִ� ������ ����
	
	private ArrayList<String> dishes = new ArrayList<>();
	
	public synchronized void add(String dish) { // synch �߰�
		// ���̺� ������ ����á����, ���̺� ������ �߰����� �ʴ´�.
		while (dishes.size() >= MAX_FOOD) {
			String name = Thread.currentThread().getName();
			System.out.println(name + " is waiting.");
			try {
				wait();
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}
		}
		dishes.add(dish);
		notify(); // ��ٸ��� �ִ� CUST�� �ƿ�� ����.
		System.out.println("Dishes : " + dishes.toString());
		
		 * if (dishes.size() >= MAX_FOOD) return; dishes.add(dish);
		 * System.out.println("Dishes : " + dishes.toString());
		 
	}
	
	public void remove(String dishName) {
		synchronized (this) {
			String name = Thread.currentThread().getName();
			
			while (dishes.size() == 0) {
				System.out.println(name + " is waiting");
				try {
					wait();
					Thread.sleep(500);
				} catch (InterruptedException e) {}
			}
			while(true) {
				for (int i = 0; i < dishes.size(); i++) {
					if (dishName.equals(dishes.get(i))) {
						dishes.remove(i);
						notify();
						return;
					}
				}//for�� ��
				try {
					System.out.println(name+" is waiting.");
					wait();
					Thread.sleep(500);
				}catch (InterruptedException e) {}
			}//(while(true)
		}//synch ����
	}
	
	
	 * public boolean remove(String dishName) { synchronized (this) { String name =
	 * Thread.currentThread().getName();
	 * 
	 * while (dishes.size() == 0) { System.out.println(name + " is waiting"); try {
	 * Thread.sleep(500); } catch (InterruptedException e) {} } for (int i = 0; i <
	 * dishes.size(); i++) if (dishName.equals(dishes.get(i))) { dishes.remove(i);
	 * return true; } } //synch ���� return false; }
	 
	public int dishNum() {
		return dishNames.length;
	}
}
*/