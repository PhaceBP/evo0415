package hu.evosoft.javasetraining.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Todo {

	public enum Level { MAJOR, MINOR, CRITICAL};
	
	Level level() default Level.MINOR;
	
	String description();
	
	
	
}
