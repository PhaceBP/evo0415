package hu.evosoft.javasetraining.multithreading.concurrent;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class DelayedQueueTest {

	public static void main(String[] args) throws InterruptedException {

		ExecutorService executor = Executors.newFixedThreadPool(2);

		BlockingQueue<DelayObject> queue = new DelayQueue<>();
		int numberOfElementsToProduce = 2;
		int delayOfEachProducedMessageMilliseconds = 4000;

		DelayedQueueProducer producer = new DelayedQueueProducer(queue, numberOfElementsToProduce,
				delayOfEachProducedMessageMilliseconds);

		DelayedQueueConsumer consumer = new DelayedQueueConsumer(queue, numberOfElementsToProduce);

		// when
		executor.submit(producer);
		executor.submit(consumer);

		// then
		executor.awaitTermination(5, TimeUnit.SECONDS);
		executor.shutdown();

		System.out.println(consumer.getNumberOfConsumedElements().get() + " : " + numberOfElementsToProduce);
	}
}
