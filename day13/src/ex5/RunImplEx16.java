package ex5;

public class RunImplEx16 implements Runnable {
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	volatile boolean suspended = false;
	volatile boolean stopped = false;

	public void run() {
		while (!stopped) {
			if (!suspended) {
				System.out.println(Thread.currentThread().getName());
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
				}
			}
		}
		System.out.println(Thread.currentThread().getName() + "-stopped");
	}

	public void suspend() {
		suspended = true;
	}

	public void resume() {
		suspended = false;
	}

	public void stop() {
		stopped = true;
	}
}
