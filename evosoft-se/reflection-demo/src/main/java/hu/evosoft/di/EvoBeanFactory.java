package hu.evosoft.di;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import hu.evosoft.reflectiondemo.examples.BenchMarked;
import hu.evosoft.reflectiondemo.examples.Secure;

public class EvoBeanFactory {

	private static final Map<String, BeanDefinition> BEAN_DEF_MAP = new HashMap<String, BeanDefinition>();

	private static final Map<String, Object> SINGLETON_MAP = new HashMap<String, Object>();

	private static final List<AnnotationPreProcessor> PREPROCESSORS = new ArrayList<AnnotationPreProcessor>();
	static {
		PREPROCESSORS.add(new DependencyInjectorAnnotationPreprocessor());
		PREPROCESSORS.add(new SystemPropertyInjectorAnnotationPreprocessor());
	}

	private static String generateBeanId(String className) {
		return className.substring(className.lastIndexOf('.') + 1, className.length());
	}

	public static void registerBean(String className) {
		registerBean(className, Scope.SINGLETON);
	}

	public static void registerBean(Class<?> clazz) {
		registerBean(clazz.getName(), Scope.SINGLETON);
	}

	public static void registerBean(String className, Scope scope) {

		String beanId = generateBeanId(className);

		if (BEAN_DEF_MAP.containsKey(beanId)) {
			System.out.println("Bean already registered to the container {" + beanId + "}");
		}

		BeanDefinition def = new BeanDefinition();
		def.setClassName(className);
		def.setId(beanId);
		def.setBeanScope(scope);

		BEAN_DEF_MAP.put(beanId, def);
	}

	public static Object getBean(String beanId) {

		BeanDefinition def = BEAN_DEF_MAP.get(beanId);

		if (def == null) {
			throw new IllegalArgumentException("Missing bean from the container with id: " + beanId);
		}

		Object instance = null;

		if (Scope.SINGLETON == def.getBeanScope()) {

			if (SINGLETON_MAP.containsKey(beanId)) {

				instance = SINGLETON_MAP.get(beanId);
			} else {
				instance = createObject(def);
				SINGLETON_MAP.put(beanId, instance);

			}
		} else if (Scope.PROTOTYPE == def.getBeanScope()) {

			instance = createObject(def);
		}

		return instance;
	}

	private static Object createObject(BeanDefinition def) {

		Object proxy = null;

		try {
			Class<?> beanClazz = Class.forName(def.getClassName());
			Object instance = beanClazz.getConstructor().newInstance();
			List<Field> fields = getAllField(new ArrayList<Field>(), beanClazz);

			for (Field f : fields) {

				PREPROCESSORS.stream().forEach(p -> p.preProcessField(instance, f));
			}

			if (beanClazz.getAnnotation(Secure.class) != null) {

				proxy = ProxyFactoryBean.createSecurityProxy(instance);
			}
			if (beanClazz.getAnnotation(BenchMarked.class) != null) {

				if (proxy == null) {
					proxy = ProxyFactoryBean.createBenchMarkProxy(instance);
				} else {
					proxy = ProxyFactoryBean.createBenchMarkProxy(proxy);
				}

			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return proxy;
	}

	private static List<Field> getAllField(List<Field> fields, Class<?> clazz) {

		List<Field> allField = new ArrayList<Field>();

		allField.addAll(Arrays.asList(clazz.getDeclaredFields()));

		if (clazz.getSuperclass() != null) {

			getAllField(allField, clazz.getSuperclass());
		}

		return allField;
	}
}
