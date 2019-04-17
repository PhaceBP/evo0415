package hu.evosoft.javasetraining.functional;

import java.util.stream.Stream;

public class StringStreamFilter {

	public static void main(String[] args) {

		Stream.of("c1", "e1", "a1", "b1", "a2", "b2", "a3")
		.filter(c -> {
			System.out.println("Filter: " + c);
			return c.startsWith("a");

		})
		.map(c -> {
			System.out.println("Map: " + c);
			return c.toUpperCase();
		})
		.sorted((c1, c2) -> {
			System.out.println("Sort c1: " + c1 + " , c2: " + c2);
			return c1.compareTo(c2);
		})
		.forEach(c -> System.out.println("Foreach: " + c));

	}

}
