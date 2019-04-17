package hu.evosoft.javasetraining.multithreading.concurrent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CountDownLatchDemo2 {

	static class Worker implements Runnable {
		private List<String> outputScraper;
		private CountDownLatch countDownLatch;

		public Worker(List<String> outputScraper, CountDownLatch countDownLatch) {
			this.outputScraper = outputScraper;
			this.countDownLatch = countDownLatch;
		}

		@Override
		public void run() {
			if (true) {
				throw new RuntimeException("Oh dear, I'm a BrokenWorker");
			}
			outputScraper.add("Counted down");
			countDownLatch.countDown();

		}
	}

	public static void main(String[] args) throws InterruptedException {

		List<String> outputScraper = Collections.synchronizedList(new ArrayList<>());
		CountDownLatch countDownLatch = new CountDownLatch(5);
		List<Thread> workers = Stream.generate(() -> new Thread(new Worker(outputScraper, countDownLatch))).limit(5)
				.collect(Collectors.toList());

		workers.forEach(Thread::start);
		countDownLatch.await();
	}

}
