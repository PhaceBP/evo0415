package hu.evosoft.javasetraining.multithreading.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.stream.IntStream;

class CounterUsingMutex {

	private Semaphore mutex;
	private int count;

	CounterUsingMutex() {
		mutex = new Semaphore(1);
		count = 0;
	}

	void increase() throws InterruptedException {
		System.out.println("hasQueuedThreads: " + hasQueuedThreads());
		mutex.acquire();
		System.out.println("Thread name: " + Thread.currentThread().getName());
		this.count = this.count + 1;
		mutex.release();
	}

	int getCount() {
		return this.count;
	}

	boolean hasQueuedThreads() {
		return mutex.hasQueuedThreads();
	}

	public static void main(String[] args) {

		int count = 5;
		ExecutorService executorService = Executors.newFixedThreadPool(count);
		CounterUsingMutex counter = new CounterUsingMutex();
		IntStream.range(0, count).forEach(user -> executorService.execute(() -> {
			try {
				counter.increase();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}));
		executorService.shutdown();

		System.out.println("Has queued threads: " + counter.hasQueuedThreads());
	}
}