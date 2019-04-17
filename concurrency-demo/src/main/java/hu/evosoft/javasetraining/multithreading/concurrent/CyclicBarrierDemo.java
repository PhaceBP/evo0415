package hu.evosoft.javasetraining.multithreading.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {

	static class Task implements Runnable {

		private CyclicBarrier barrier;

		public Task(CyclicBarrier barrier) {
			this.barrier = barrier;
		}

		@Override
		public void run() {
			try {
				System.out.println(Thread.currentThread().getName() + " is waiting");
				barrier.await();
				System.out.println(Thread.currentThread().getName() + " is released");
			} catch (InterruptedException | BrokenBarrierException e) {
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) {

		CyclicBarrier cyclicBarrier = new CyclicBarrier(3, () -> {
			System.out.println("All previous tasks are completed");
		});

		Thread t1 = new Thread(new Task(cyclicBarrier), "T1");
		Thread t2 = new Thread(new Task(cyclicBarrier), "T2");
		Thread t3 = new Thread(new Task(cyclicBarrier), "T3");

		if (!cyclicBarrier.isBroken()) {
			t1.start();
			t2.start();
			t3.start();
		}
	}
}
