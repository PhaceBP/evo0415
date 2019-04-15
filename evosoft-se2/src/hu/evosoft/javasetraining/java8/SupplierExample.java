package hu.evosoft.javasetraining.java8;

import java.util.function.Supplier;

public class SupplierExample {

	public static void main(String[] args) {
		Supplier<String> i = () -> "HelloWorld";

		System.out.println(i.get());
	}
}
