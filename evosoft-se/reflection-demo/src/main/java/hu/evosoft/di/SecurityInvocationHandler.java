package hu.evosoft.di;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import hu.evosoft.di.test.App;
import hu.evosoft.reflectiondemo.examples.Roles;
import hu.evosoft.reflectiondemo.examples.Secure;

public class SecurityInvocationHandler implements InvocationHandler {

	private Object targetObject;

	public SecurityInvocationHandler(Object invocationTarget) {
		this.targetObject = invocationTarget;
	}

	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

		Secure s = method.getDeclaredAnnotation(Secure.class);

		if (s == null) {
			return method.invoke(targetObject, args);
		}

		Roles requiredRole = s.role();

		if (App.CURRENT_USER_ROLE_HOLDER.get() != requiredRole) {
			throw new SecurityException("Unsufficient privilege!");
		}

		return method.invoke(targetObject, args);
	}

}
