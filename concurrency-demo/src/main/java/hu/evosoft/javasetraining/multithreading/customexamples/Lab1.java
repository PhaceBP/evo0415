package hu.evosoft.javasetraining.multithreading.customexamples;

public class Lab1 {

	static class MyThread extends Thread {
		
		public MyThread(String name){
			super(name);
		}
		@Override
		public void run() {
			System.out.println(getName());
		}

	}

	static class MyRunnable implements Runnable {

		public void run() {

			while(true) {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName());
			}

		}

	}

	public static void main(String[] args) {

		MyThread t1 = new MyThread("thread1");
		t1.start();

		Thread t2 = new Thread(new MyRunnable(), "thread2");

		t2.start();
	}
}
