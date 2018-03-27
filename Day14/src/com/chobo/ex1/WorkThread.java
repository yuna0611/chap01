package com.chobo.ex1;

public class WorkThread extends Thread{
	public WorkThread(ThreadGroup threadGroup, String threadName) {
		super(threadGroup, threadName);
	}

	@Override
	public void run() {
		super.run();
		while(true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println(getName()+" interrupted");
				break;
			}
		}
		System.out.println(getName()+ " Á¾·áµÊ.");
	}
}
