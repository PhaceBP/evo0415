package hu.evosoft.di;

import java.lang.reflect.Field;

public interface AnnotationPreProcessor {

	
	void preProcessField(Object target, Field actualField);
	
}
