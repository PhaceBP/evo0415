package hu.evosoft.javasetraining.functional;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NumberHolder {

	private int value;

	public NumberHolder() {

		value = (int) ((Math.random() * 1000) + 1);
		System.out.println("Generated random number: " + value);
	}

	public int getValue() {
		return value;
	}

	public static void main(String[] args) {
		
		Supplier<Stream<NumberHolder>> streamSupplier = () ->  Stream.generate(() -> new NumberHolder()).limit(100);
		
		List<Integer> result = streamSupplier.get().filter(n -> n.getValue() > 500 && n.getValue() < 1000)
				.map(n -> n.getValue()).collect(Collectors.toList());

		System.out.println(result.size());

		
		System.out.println(streamSupplier.get().findAny());

	}
}
