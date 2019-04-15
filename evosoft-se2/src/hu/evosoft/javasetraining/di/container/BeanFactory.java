package hu.evosoft.javasetraining.di.container;

public interface BeanFactory {

	void registerBean(String classname);

	void registerBean(String classname, Scope scope);
	
	Object getBean(String id);
}
