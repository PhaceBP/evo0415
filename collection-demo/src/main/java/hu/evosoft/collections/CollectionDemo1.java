package hu.evosoft.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionDemo1 {

	public static void main(String[] args) {

		Collection<Object> collection = new ArrayList<Object>();
		
		collection.add(1);
		collection.add("String");
		
		iterate(collection);
	}

	public static void iterate(Collection<Object> collection) {

		Iterator<Object> iterator = collection.iterator();
		while (iterator.hasNext()) {
			Object object = iterator.next();
			System.out.println(object);
		}
	}
}
