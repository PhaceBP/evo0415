package hu.evosoft.javasetraining.java8;

import java.util.function.Consumer;
import java.util.function.Function;

public class ConsumerExample {

	public static void main(String[] args) {
		
		Consumer<String> c = (x) -> {
			System.out.println(x.toLowerCase());
			
		};
		
		c.accept("HelloWorld");
		
		Function<Integer, String> convertToString = String::valueOf;
		
		String res = convertToString.apply(10);
		
		System.out.println(res);
	}
}
