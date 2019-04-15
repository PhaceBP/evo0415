package hu.evosoft.javasetraining.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class CollectionDemo1 {

	public static void main(String[] args) {

		List<Integer> numberList = new ArrayList<>();
		
		
		List<Long> longList = new ArrayList<>();
		

		long start = System.currentTimeMillis();
		System.out.println("Array start: " + start);
		for (int i = 0; i < 100; i++) {
			numberList.add(i);
		}
		
		long end = System.currentTimeMillis();

		System.out.println("Array end: " + end);

		System.out.println("Result: " + (end - start) + "in ms.");

		for (Integer e : numberList) {

			System.out.println("Array Number : " + e);
		}

		numberList = new LinkedList<>();

		start = System.currentTimeMillis();
		System.out.println("Linked start: " + start);
		for (int i = 0; i < 100; i++) {
			numberList.add(i);
		}
		end = System.currentTimeMillis();

		System.out.println("Linked end: " + end);

		System.out.println("Result: " + (end - start) + "in ms.");

		for (Integer e : numberList) {

			System.out.println("Linked Number : " + e);
		}

		Map<String, Object> map = new TreeMap<>();

		map.put("banán", "valami");
		map.put("alma", "valami");

		System.out.println(map.values());
		System.out.println(map.keySet().size());

		for (Map.Entry<String, Object> e : map.entrySet()) {

			System.out.println("Map entry : " + e.getKey() + " / " + e.getValue());
		}

		Set<String> stringSet = new HashSet<>();

		stringSet.add("banán");
		stringSet.add("alma");
		stringSet.add("alma");

		for (String s : stringSet) {
			System.out.println("Set : " + s);
		}
	}
}
