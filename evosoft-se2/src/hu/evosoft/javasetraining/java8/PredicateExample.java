package hu.evosoft.javasetraining.java8;

import java.util.function.Predicate;

public class PredicateExample {

	public static void main(String[] args) {
		Predicate<String> p = (x) -> { return "example".equals(x); };
		System.out.println(p.test("alma"));
		
		Predicate<String> p2 = (x) -> { return "example".equals(x); };
		System.out.println(p2.test("example"));
	}
}
