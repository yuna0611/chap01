package ex10;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadWaitEx1 {
	public static void main(String[] args) throws Exception{
		Table table = new Table();	//���� �����尡 �����ϴ� ��ü
		
	/*	new Thread(new Cook(table),"COOK1").start();
		new Thread(new Customer(table,"donut"),"CUST1").start();
		new Thread(new Customer(table,"burger"),"CUST2").start();*/
		
		ExecutorService executorService = Executors.newFixedThreadPool(4);
		
		executorService.submit(new Cook(table,"what"));
		executorService.submit(new Customer(table,"donut","CUST1"));
		executorService.submit(new Customer(table,"burger","CUST2"));
		//0.1ch (100ms) �Ŀ� ���� ����
		Thread.sleep(2000);
		System.exit(0);
	}
}
