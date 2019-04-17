package hu.evosoft.javasetraining.multithreading;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumer2 {

	static class Producer implements Runnable {

		private final BlockingQueue queue;

		Producer(BlockingQueue q) {
			queue = q;
		}

		public void run() {
			try {
				while (true) {
					queue.put(produce());
				}
			} catch (InterruptedException ex) {

			}
		}

		Object produce() {

			return null;
		}
	}

	static class Consumer implements Runnable {
		private final BlockingQueue queue;

		Consumer(BlockingQueue q) {
			queue = q;
		}

		public void run() {
			try {
				while (true) {
					consume(queue.take());
				}
			} catch (InterruptedException ex) {

			}
		}

		void consume(Object x) {

		}
	}

	public static void main(String[] args) {
		BlockingQueue q = new LinkedBlockingQueue<>();
		Producer p = new Producer(q);
		Consumer c1 = new Consumer(q);
		Consumer c2 = new Consumer(q);
		new Thread(p).start();
		new Thread(c1).start();
		new Thread(c2).start();
	}

}
