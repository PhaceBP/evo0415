package hu.evosoft.di;

import java.lang.reflect.Field;

public class DependencyInjectorAnnotationPreprocessor implements AnnotationPreProcessor {

	public void preProcessField(Object target, Field actualField) {

		if ((actualField.getAnnotation(Inject.class) != null)) {

			if (actualField.getClass().isPrimitive()) {
				Object fieldValue = null;

				try {
					fieldValue = actualField.getType().getConstructor().newInstance();
					actualField.setAccessible(true);
					actualField.set(target, fieldValue);

					for (Field transitiveDependency : actualField.getType().getDeclaredFields()) {

						preProcessField(target, transitiveDependency);
					}
				} catch (Exception e) {
					e.printStackTrace();
					throw new IllegalArgumentException(e);
				}
			}

		}

	}

}
