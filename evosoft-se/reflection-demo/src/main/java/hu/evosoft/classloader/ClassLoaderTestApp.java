package hu.evosoft.classloader;

import java.lang.reflect.InvocationTargetException;

public class ClassLoaderTestApp {


	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, SecurityException {

		System.out.println("Class loader for HashMap: " + java.util.HashMap.class.getClassLoader());

		System.out.println("Class loader for this class: " + ClassLoaderTestApp.class.getClassLoader());
		
		ClassLoader cl = ClassLoaderTestApp.class.getClassLoader();
		
		Class<?> clazz = cl.loadClass("hu.evosoft.classloader.DynamicClassLoadingTest");
		
		DynamicClassLoadingTest obj = (DynamicClassLoadingTest) clazz.getConstructors()[0].newInstance();
		
		System.out.println(obj);
	}
}
