package hu.evosoft.di.test;

import hu.evosoft.di.Inject;
import hu.evosoft.di.PropertySource;
import hu.evosoft.reflectiondemo.examples.BenchMarked;
import hu.evosoft.reflectiondemo.examples.Roles;
import hu.evosoft.reflectiondemo.examples.Secure;

@Secure(role = Roles.ADMIN)
@BenchMarked
public class ServiceClient  {

	@Inject
	private DefaultService service;

	@PropertySource(propertyName = "java.version")
	private String javaVersion;

	public DefaultService getService() {
		return service;
	}

	public void setDefaultService(DefaultService service) {
		this.service = service;
	}

	public String getJavaVersion() {
		return javaVersion;
	}

	public void setJavaVersion(String javaVersion) {
		this.javaVersion = javaVersion;
	}

}
