package hu.evosoft.javasetraining.generics2;

public class GenericMethodDemo<B extends Object> {

	public static <T extends Number> void inspect(T object) {
		System.out.println("T object cla[ss " + object.getClass());
		System.out.println("T object: " + object);
	}
	
	
	public static void main(String[]args) {
		
		
		GenericMethodDemo.inspect(3);
		GenericMethodDemo.inspect(4L);
		GenericMethodDemo.inspect(3.14D);
		
	}
}
