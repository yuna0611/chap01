package com.chobo.ex2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ExecuteExample {
	public static void main(String[] args) throws Exception{
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		
		for (int i = 0; i < 10; i++) {
			Runnable runnable = new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor)executorService;
					int poolSize = threadPoolExecutor.getPoolSize();
					String threadName = Thread.currentThread().getName();
					System.out.println("[�� ������ ����: "+poolSize+"] �۾� ������ �̸� : "+threadName);
					
					int value = Integer.parseInt("a");
				}
			};
			 
			executorService.execute(runnable);
			Thread.sleep(10);
		}
		executorService.shutdown();
	}
}
