package hu.evosoft.di.test;

import hu.evosoft.di.PropertySource;
import hu.evosoft.reflectiondemo.examples.BenchMarked;
import hu.evosoft.reflectiondemo.examples.Roles;
import hu.evosoft.reflectiondemo.examples.Secure;

@Secure(role = Roles.ADMIN)
@BenchMarked
public class DefaultService implements Service {

	@PropertySource(propertyName = "os.name")
	private String osName;

	public String getOsName() {
		return osName;
	}

	public void setOsName(String osName) {
		this.osName = osName;
	}

}
