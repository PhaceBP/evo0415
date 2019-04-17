package hu.evosoft.collections;

import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeSet;

/*
 * The java.util.SortedSet interface is a subtype of the java.util.Set interface. It behaves like a normal set with the exception that the elements are sorted internally. 
 * This means that when you iterate the elements of a SortedSet the elements are returned in the sorted order.

   The order of the sorting is either the natural sorting order of the elements (if they implement java.lang.Comparable), 
   or the order determined by a Comparator that you can give to the SortedSet.

   By default the elements are iterated in ascending order, starting with the "smallest" and moving towards the "largest". 
   But it is also possible to iterate the elements in descending order using the method TreeSet.descendingIterator().

   The Java Collections API only has one implementation of the SortedSet interface - the java.util.TreeSet class. 
   The java.util.concurrent package also has an implementation of this interface, but I will leave the concurrency utilities out of this trail.

   Here are two examples of how to create a SortedSet:
 */
public class SetExample {
	
	
	public static void main(String[]args) {
		
		SortedSet<Integer> setA = new TreeSet<>();

		setA.add(2);
		setA.add(1);
		setA.add(3);
		
		setA.stream().forEach(c -> System.out.println(c));
		
		System.out.println("---------------------------");
		
		
		NavigableSet<Integer> original = (NavigableSet<Integer>) setA;
		
		//this headset will contain "1" and "2"
		SortedSet<Integer> headset = original.headSet(3);
		
		headset.stream().forEach(c -> System.out.println(c));
		
		System.out.println("---------------------------");

		//this headset will contain "1", "2", and "3" because "inclusive"=true
		headset = original.headSet(3, true);
		
		headset.stream().forEach(c -> System.out.println(c));
		
		System.out.println("---------------------------");
		
		//ceiling will be "2".
		Integer ceiling = original.ceiling(2);
		
		System.out.println("Ceiling value: "+ceiling);

		//floor will be "2".
		Integer floor = original.floor(2);
		
		System.out.println("Floor value: "+floor);
		
		
		System.out.println("---------------------------");


		//first is "1"
		Object first = original.pollFirst();

		//last is "3"
		Object last = original.pollLast();
		
		original.stream().forEach(c -> System.out.println(c));
		
		System.out.println("---------------------------");
	}

}
