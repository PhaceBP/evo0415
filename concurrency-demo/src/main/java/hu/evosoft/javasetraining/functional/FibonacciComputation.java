package hu.evosoft.javasetraining.functional;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class FibonacciComputation extends RecursiveTask<Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final int number;

	public FibonacciComputation(int number) {
		this.number = number;
	}

	@Override
	public Integer compute() {
		if (number <= 1)
			return number;

		FibonacciComputation f1 = new FibonacciComputation(number - 1);
		FibonacciComputation f2 = new FibonacciComputation(number - 2);
		ForkJoinTask.invokeAll(f1, f2);

		return f1.join() + f2.join();
	}

	public static void main(String args[]) {
		int number = 40;
		int poolSize = Runtime.getRuntime().availableProcessors();
		ForkJoinPool pool = new ForkJoinPool(poolSize);
		long beforeTime = System.currentTimeMillis();
		System.out.println("Parallelism  => " + pool.getParallelism());
		Integer result = (Integer) pool.invoke(new FibonacciComputation(number));
		System.out.println("Total Time in MilliSecond Taken ->  " + (System.currentTimeMillis() - beforeTime));
		System.out.println(number + "the element of Fibonacci Number = " + result);
	}
}