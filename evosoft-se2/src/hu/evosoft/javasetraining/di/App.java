package hu.evosoft.javasetraining.di;

import hu.evosoft.javasetraining.di.container.BeanFactory;
import hu.evosoft.javasetraining.di.container.DefaultBeanFactory;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BeanFactory f = new DefaultBeanFactory();
		
		f.registerBean("hu.training360.javasetraining.di.A");
		f.registerBean("hu.training360.javasetraining.di.B");
		
		
		A object = (A) f.getBean("A");
		
		System.out.println("A object from container is null?"+object);
		System.out.println("B object as dependency is: "+object != null? object.getInstance() : "null");
	}

}
