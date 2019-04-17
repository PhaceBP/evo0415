package hu.evosoft.collections;

import java.util.ArrayList;
import java.util.List;

public class CollectionDemo2 {

	public static void sum(Number[] data) {

		long res = 0;

		for (Number n : data) {

			res += n.longValue();
		}

		System.out.println("Sum res : " + res);
	}

	public static void sum(List<? extends Number> data) {

		long res = 0;

		for (Number n : data) {

			res += n.longValue();
		}

		System.out.println("Sum res : " + res);
	}

	public static void main(String[] args) {

		Number[] numberArray = new Number[100];
		numberArray[0] = Integer.valueOf(100);
		numberArray[1] = Integer.valueOf(120);
		numberArray[5] = Integer.valueOf(200);

		Integer[] numberInteger = new Integer[100];

		numberInteger[0] = 12;

		numberArray = numberInteger;

		// ArrayStoreException
		// numberArray[2] = 5.12d;

		for (Number n : numberArray) {

			System.out.println(n);
		}

		// csak integerek tarolhatunk!
		List<Number> numberList = new ArrayList<>();

		List<Integer> intList = new ArrayList<>();

		for (Number n : numberList) {

			System.out.println("Number list: " + n);
		}

		List<? extends Number> readOnly = new ArrayList<>();

		// readOnly.add(12);
		Number n = readOnly.get(0);

		List<? super Number> putOnly = new ArrayList<>();

		putOnly.add(new Integer(1));
		// Number n = putOnly.get(0);

		List<Double> data = new ArrayList<>();
		
		sum(data);
	}

}
