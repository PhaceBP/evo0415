package hu.evosoft.javasetraining.multithreading.concurrent;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class DelayedQueueConsumer implements Runnable {
	
	private BlockingQueue<DelayObject> queue;
	private Integer numberOfElementsToTake;
	public AtomicInteger numberOfConsumedElements = new AtomicInteger();

	// standard constructors

	public DelayedQueueConsumer(BlockingQueue<DelayObject> queue, Integer numberOfElementsToTake) {
		this.queue = queue;
		this.numberOfElementsToTake = numberOfElementsToTake;
	}

	@Override
	public void run() {
		for (int i = 0; i < numberOfElementsToTake; i++) {
			try {
				DelayObject object = queue.take();
				numberOfConsumedElements.incrementAndGet();
				System.out.println("Consumer take: " + object);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public BlockingQueue<DelayObject> getQueue() {
		return queue;
	}

	public Integer getNumberOfElementsToTake() {
		return numberOfElementsToTake;
	}

	public AtomicInteger getNumberOfConsumedElements() {
		return numberOfConsumedElements;
	}

}