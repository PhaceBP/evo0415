package hu.evosoft.javasetraining.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ModifierTest {

	private String testField;

	public void doNothing() {

		System.out.println("In doNothing method!");
	}

	private void doNothing2() {

		System.out.println("In doNothing2 method!");
	}

	public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException,
			IllegalAccessException, InstantiationException, InvocationTargetException {

		Class<?> clazz = ModifierTest.class;

		Method[] methods = clazz.getMethods();

		for (Method m : methods) {

			int modifier = m.getModifiers();

			System.out.println("Method name is : "+m.getName());
			System.out.println("Is final this class? ==> " + Modifier.isFinal(modifier));
			System.out.println("Is abstract this class? ==> " + Modifier.isAbstract(modifier));
			System.out.println("Is interface this class? ==> " + Modifier.isInterface(modifier));
			System.out.println("Is static this class? ==> " + Modifier.isStatic(modifier));
			System.out.println("Is public this class? ==> " + Modifier.isPublic(modifier));

		}

		Field testField = clazz.getDeclaredField("testField");

		System.out.println("Field found : " + testField);

		ModifierTest t = new ModifierTest();
		t.testField = "alma";

		System.out.println(testField.get(t));
		testField.set(t, "almaoverrided!");
		System.out.println(testField.get(t));

		Constructor[] consts = clazz.getDeclaredConstructors();

		for (Constructor c : consts) {

			System.out.println("Constructor found: " + c.getName());

			ModifierTest newTest = (ModifierTest) c.newInstance();

			System.out.println(newTest);
		}

	}

}
