package hu.evosoft.javasetraining.functional;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamDemo {

	
	public static void main(String[]args) {
		
		
		Collection<String> collection = Arrays.asList("a", "b", "c");
		Stream<String> streamOfCollection = collection.stream();
		
		streamOfCollection.forEach(System.out::println);
		
		//////////////////////////////////////////////////
		
		String[] arr = new String[]{"a", "b", "c"};
		Stream<String> streamOfArrayFull = Arrays.stream(arr);
		Stream<String> streamOfArrayPart = Arrays.stream(arr, 1, 3);
		
		streamOfArrayFull.forEach(System.out::println);
		streamOfArrayPart.forEach(System.out::println);
		
		//////////////////////////////////////////////////
		
		Stream<String> streamBuilder = Stream.<String>builder().add("a").add("b").add("c").build();
		
		streamBuilder.forEach(System.out::println);
		
		//////////////////////////////////////////////////
		
		Stream<String> streamGenerated =
				  Stream.generate(() -> "element").limit(10);
		
		streamGenerated.forEach(System.out::println);
		
		//////////////////////////////////////////////////
		
		Stream<Integer> streamIterated = Stream.iterate(40, n -> n + 2).limit(20);
		
		streamIterated.forEach(System.out::println);
		
		//////////////////////////////////////////////////
		
		IntStream intStream = IntStream.range(1, 3);
		LongStream longStream = LongStream.rangeClosed(1, 3);
		
		intStream.forEach(System.out::println);
		longStream.forEach(System.out::println);
		
		//////////////////////////////////////////////////
		
		Stream<String> stream = 
				  Stream.of("a", "b", "c").filter(element -> element.contains("b"));
		
		
		List<String> elements = stream.collect(Collectors.toList());
		
		Optional<String> anyElement = stream.findAny();
		
		System.out.println("Find any: "+anyElement.get());
		
		//anyElement = stream.findAny();
		
		//////////////////////////////////////////////////
		
		System.out.println("-----------------------------------------------------");
		
		int reducedParams = Stream.of(1, 2, 3)
				  .reduce(10, (a, b) -> a + b);
		
		System.out.println(reducedParams);  
		
		System.out.println("-----------------------------------------------------");
		
		int reducedParallel = Arrays.asList(1, 2, 3).parallelStream()
			    .reduce(10, (a, b) -> a + b, (a, b) -> {
			       System.out.println("combiner was called");
			       return a + b;
			    });
			    
		System.out.println(reducedParallel);  
	}
}
