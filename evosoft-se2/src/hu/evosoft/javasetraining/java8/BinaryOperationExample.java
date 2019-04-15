package hu.evosoft.javasetraining.java8;

import java.util.function.BinaryOperator;

public class BinaryOperationExample {

	public static void main(String[] args) {
		BinaryOperator<Integer> adder = (n1, n2) -> n1 + n2;

		/*
		 * Comparator<Integer> comparator = (x,y) -> { return x.compareTo(y);};
		 * System.out.println(BinaryOperator.minBy(comparator).apply(1, 2));
		 */
		System.out.println(adder.apply(3, 4));
	}
}
