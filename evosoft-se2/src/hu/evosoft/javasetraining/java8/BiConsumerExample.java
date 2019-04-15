package hu.evosoft.javasetraining.java8;

import java.util.function.BiConsumer;

public class BiConsumerExample {
	
	public static void main(String[] args) {
		
		BiConsumer<String, String> biConsumer = (x, y) -> {
			System.out.println(x);
			System.out.println(y);
		};

		biConsumer.accept("Hello", "World!");
	}
}