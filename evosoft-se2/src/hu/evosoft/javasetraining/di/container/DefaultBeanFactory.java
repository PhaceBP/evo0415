package hu.evosoft.javasetraining.di.container;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DefaultBeanFactory implements BeanFactory {

	private static final Map<String, BeanDefinition> BEAN_DEF_MAP = new HashMap<>();

	private static final Map<String, Object> SINGLETON_MAP = new HashMap<String, Object>();

	private static String generateBeanId(String className) {
		return className.substring(className.lastIndexOf('.') + 1, className.length());
	}

	@Override
	public void registerBean(String classname) {
		registerBean(classname, Scope.SINGLETON);
	}

	@Override
	public void registerBean(String classname, Scope scope) {
		String beanId = generateBeanId(classname);

		if (BEAN_DEF_MAP.containsKey(beanId)) {
			System.out.println("Bean already registered to the container {" + beanId + "}");
			return;
		}

		BeanDefinition def = new BeanDefinition();
		def.setClassFqdn(classname);
		def.setId(beanId);
		def.setScope(scope);

		BEAN_DEF_MAP.put(beanId, def);

	}

	@Override
	public Object getBean(String id) {
		
		BeanDefinition def = BEAN_DEF_MAP.get(id);

		if (def == null) {
			throw new IllegalArgumentException("Missing bean from the container with id: " + id);
		}

		Object instance = null;

		if (Scope.SINGLETON == def.getScope()) {

			if (SINGLETON_MAP.containsKey(id)) {

				instance = SINGLETON_MAP.get(id);
			} else {
				instance = createObject(def);
				SINGLETON_MAP.put(id, instance);

			}
		} else if (Scope.PROTOTYPE == def.getScope()) {

			instance = createObject(def);
		}

		return instance;
	}

	private static void injectDependencies(Object containerObject, Field f) {

		if ((f.getAnnotation(Inject.class) != null) && !f.getClass().isPrimitive()) {

			Object fieldValue = null;

			try {
				fieldValue = f.getType().newInstance();
				f.setAccessible(true);
				f.set(containerObject, fieldValue);

				for (Field transitiveDependency : f.getType().getDeclaredFields()) {

					injectDependencies(fieldValue, transitiveDependency);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private static List<Field> getAllField(List<Field> fields, Class<?> clazz) {

		List<Field> allField = new ArrayList<Field>();

		allField.addAll(Arrays.asList(clazz.getDeclaredFields()));

		if (clazz.getSuperclass() != null) {
			
			allField.addAll(getAllField(allField, clazz.getSuperclass()));
		}

		return allField;
	}

	private static Object createObject(BeanDefinition def) {

		Object instance = null;
		Class<?> beanClazz = null;
		try {
			beanClazz = Class.forName(def.getClassFqdn());
			instance = beanClazz.getConstructor().newInstance();
			List<Field> fields = getAllField(new ArrayList<Field>(), beanClazz);

			for (Field f : fields) {
				injectDependencies(instance, f);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return instance;
	}

}
