package hu.evosoft.javasetraining.reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

@Todo(todoName = "testTodo")
public class Test {

	
	private String testField;
	
	@Todo(todoName = "doNothing")
	public void doNothing() {

		System.out.println("In doNothing method!");
	}
	
	@Todo(todoName = "doNothing2")
	public void doNothing2() {

		System.out.println("In doNothing2 method!");
	}

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, InstantiationException, InvocationTargetException {

		Class<?> clazz = Test.class;

		

		Annotation[] annotations = clazz.getAnnotations();

		for (Annotation a : annotations) {

			System.out.println(a);
		}

		Method[] methods = clazz.getMethods();

		for (Method m : methods) {

			Todo todo = m.getAnnotation(Todo.class);

			if (todo != null) {
				System.out.println("Todo found, task is : " + todo.todoName());
			}

		}
		
		Field testField = clazz.getDeclaredField("testField");
		
		System.out.println("Field found : "+testField);
		
		Test t = new Test();
		t.testField = "alma";

		System.out.println(testField.get(t));
		testField.set(t, "almaoverrided!");
		System.out.println(testField.get(t));
		
		Constructor[] consts = clazz.getDeclaredConstructors();
		
		
		for(Constructor c : consts) {
			
			System.out.println("Constructor found: "+c.getName());
			
			Test newTest = (Test) c.newInstance();
			
			System.out.println(newTest);
		}

	}

}
