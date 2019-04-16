package hu.evosoft.di;

import java.lang.reflect.Field;

public class SystemPropertyInjectorAnnotationPreprocessor implements AnnotationPreProcessor {

	public void preProcessField(Object target, Field actualField) {

		PropertySource annotation = actualField.getAnnotation(PropertySource.class);

		if (annotation != null) {

			if (annotation.propertyName() != null) {
				actualField.setAccessible(true);
				try {
					actualField.set(target, System.getProperty(annotation.propertyName()));
				} catch (Exception e) {
					e.printStackTrace();
					throw new RuntimeException(e);
				}
			} else {
				throw new IllegalArgumentException("Missing property file name attribute!");
			}
		}

	}

}
