package hu.evosoft.javasetraining.multithreading.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.stream.IntStream;

class LoginQueueUsingSemaphore {

	private Semaphore semaphore;

	public LoginQueueUsingSemaphore(int slotLimit) {
		semaphore = new Semaphore(slotLimit);
	}

	boolean tryLogin() {
		return semaphore.tryAcquire();
	}

	void logout() {
		semaphore.release();
	}

	int availableSlots() {
		return semaphore.availablePermits();
	}

	public static void main(String[] args) {

		int slots = 10;
		ExecutorService executorService = Executors.newFixedThreadPool(slots);
		LoginQueueUsingSemaphore loginQueue = new LoginQueueUsingSemaphore(slots);
		IntStream.range(0, slots).forEach(user -> executorService.execute(loginQueue::tryLogin));
		executorService.shutdown();

		System.out.println("Available slots: "+loginQueue.availableSlots());
		System.out.println("Try login 1: "+loginQueue.tryLogin());
		
		loginQueue.logout();
		
		System.out.println("Available slots: "+loginQueue.availableSlots());
		System.out.println("Try login 2: "+loginQueue.tryLogin());
	}
}