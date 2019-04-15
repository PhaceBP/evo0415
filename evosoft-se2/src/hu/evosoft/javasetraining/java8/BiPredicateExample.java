package hu.evosoft.javasetraining.java8;

import java.util.function.BiPredicate;

public class BiPredicateExample {

	public static void main(String[] args) {
		BiPredicate<Integer, Integer> bi = (x, y) -> x > y;
		System.out.println(bi.test(2, 2));
		
		
		BiPredicate<String, String> bi2 = (x, y) -> x.equals(y);
		System.out.println(bi2.test("alma", "alma2"));
	}
}
