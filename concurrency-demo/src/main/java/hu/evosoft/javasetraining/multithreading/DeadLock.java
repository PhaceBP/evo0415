package hu.evosoft.javasetraining.multithreading;

public class DeadLock {

	private static Object lock1 = new Object();
	private static Object lock2 = new Object();

	static class Worker1 extends Thread {

		@Override
		public void run() {
			
			synchronized(lock1) {
				
				System.out.println("Accquiring lock in worker1...");
				
				synchronized(lock2) {
					
					System.out.println("Accquiring lock2 in worker1...");
				}
			}
		}

	}

	static class Worker2 extends Thread {

		@Override
		public void run() {
			
			synchronized(lock2) {
				
				System.out.println("Accquiring lock in worker2...");
				
				synchronized(lock1) {
					
					System.out.println("Accquiring lock1 in worker2...");
				}
			}
		}
	}

	public static void main(String[] args) {
		
		new Worker1().start();
		new Worker2().start();

	}
}
