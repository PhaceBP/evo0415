package hu.evosoft.javasetraining.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Reduce {

	public static void main(String[] args) {
		
		List<String> stringList = new ArrayList<String>();

		stringList.add("One flew over the cuckoo's nest");
		stringList.add("To kill a muckingbird");
		stringList.add("Gone with the wind");

		Stream<String> stream = stringList.stream();

		Optional<String> reduced = stream.reduce((value, combinedValue) -> {
		    return combinedValue + " + " + value;
		});

		System.out.println(reduced.get());

	}

}
