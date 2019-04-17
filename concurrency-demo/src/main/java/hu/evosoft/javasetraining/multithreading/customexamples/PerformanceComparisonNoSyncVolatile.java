package hu.evosoft.javasetraining.multithreading.customexamples;

public class PerformanceComparisonNoSyncVolatile {

	static class Counter {

		private volatile long count;

		public Counter(long count) {
			this.count = count;
		}

		public void incrementByOne() {
			count++;
		}

		public long getCount() {
			return count;
		}
	}

	public static void main(String[] args) {

		Counter c = new Counter(0L);
		long startTime = System.currentTimeMillis();
		for (long i = 0; i < 1000000000L; i++) {
			c.incrementByOne();
		}
		long endTime = System.currentTimeMillis();

		System.out.println("Time taken : " + (endTime - startTime) + " ms");
		System.out.println("Result is : " + c.getCount());
	}
}
