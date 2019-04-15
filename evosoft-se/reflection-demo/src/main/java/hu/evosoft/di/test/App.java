package hu.evosoft.di.test;

import static hu.evosoft.di.EvoBeanFactory.registerBean;

import hu.evosoft.di.EvoBeanFactory;
import hu.evosoft.reflectiondemo.examples.Roles;

public class App {

	public static ThreadLocal<Roles> CURRENT_USER_ROLE_HOLDER = new ThreadLocal<Roles>();

	static {
		CURRENT_USER_ROLE_HOLDER.set(Roles.USER);
	}

	public static void main(String[] args) {

		registerBean("hu.evosoft.di.test.DefaultService");

		Service service = (Service) EvoBeanFactory.getBean("DefaultService");

		System.out.println(service);
		
		System.out.println(service.getOsName());

	}
}
