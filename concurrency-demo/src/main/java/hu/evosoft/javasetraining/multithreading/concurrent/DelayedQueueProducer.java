package hu.evosoft.javasetraining.multithreading.concurrent;

import java.util.UUID;
import java.util.concurrent.BlockingQueue;

public class DelayedQueueProducer implements Runnable {

	private BlockingQueue<DelayObject> queue;
	private Integer numberOfElementsToProduce;
	private Integer delayOfEachProducedMessageMilliseconds;

	// standard constructor
	public DelayedQueueProducer(BlockingQueue<DelayObject> queue, Integer numberOfElementsToProduce,
			Integer delayOfEachProducedMessageMilliseconds) {
		this.queue = queue;
		this.numberOfElementsToProduce = numberOfElementsToProduce;
		this.delayOfEachProducedMessageMilliseconds = delayOfEachProducedMessageMilliseconds;
	}

	@Override
	public void run() {
		for (int i = 0; i < numberOfElementsToProduce; i++) {
			DelayObject object = new DelayObject(UUID.randomUUID().toString(), delayOfEachProducedMessageMilliseconds);
			System.out.println("Put object: " + object);
			try {
				queue.put(object);
				Thread.sleep(500);
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		}
	}

	public BlockingQueue<DelayObject> getQueue() {
		return queue;
	}

	public Integer getNumberOfElementsToProduce() {
		return numberOfElementsToProduce;
	}

	public Integer getDelayOfEachProducedMessageMilliseconds() {
		return delayOfEachProducedMessageMilliseconds;
	}

}